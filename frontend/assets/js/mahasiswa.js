// ==========================================
// Cek Login
// ==========================================
const user = JSON.parse(localStorage.getItem("user") || "null");

if (!user) {
  window.location.href = "../../login.html";
}

// ==========================================
// Load Sidebar
// ==========================================
fetch("../../components/sidebar-dosen.html")
  .then((res) => res.text())
  .then((html) => {
    const container = document.getElementById("sidebar-container");
    if (container) container.innerHTML = html;

    const menu = document.getElementById("menu-mahasiswa");

    if (menu) {
      menu.classList.add("active");
    }

    const logoutBtn = document.getElementById("logoutBtn");

    if (logoutBtn) {
      logoutBtn.addEventListener("click", logout);
    }
  })
  .catch((e) => console.warn("Failed to load sidebar", e));

// ==========================================
// Logout
// ==========================================
function logout() {
  localStorage.removeItem("user");
  window.location.href = "../../login.html";
}

// ==========================================
// Ambil Data Mahasiswa
// ==========================================
async function loadMahasiswa(keyword = "") {
  const tbody = document.getElementById("tableMahasiswa");
  if (!tbody) return;

  tbody.innerHTML = `<tr><td colspan="7" class="text-center">Loading...</td></tr>`;

  let url = BASE_URL + "/mahasiswa";
  if (keyword && keyword.trim() !== "") {
    url = BASE_URL + "/mahasiswa/search?keyword=" + encodeURIComponent(keyword);
  }

  try {
    const response = await fetch(url);
    if (!response.ok) {
      const text = await response.text().catch(() => "");
      console.error("API error:", response.status, text);
      tbody.innerHTML = `<tr><td colspan="7" class="text-center">Gagal mengambil data (status ${response.status})</td></tr>`;
      return;
    }

    let data = await response.json();

    // normalize single object -> array
    if (data && !Array.isArray(data)) {
      data = data ? [data] : [];
    }

    if (!data || data.length === 0) {
      tbody.innerHTML = `
                <tr>
                    <td colspan="7" class="text-center">
                        Tidak ada data mahasiswa
                    </td>
                </tr>
            `;
      return;
    }

    tbody.innerHTML = "";

    data.forEach((mhs, index) => {
      const nim = mhs.nim ?? "";
      const nama = mhs.nama ?? "";
      const email = mhs.email ?? "";
      const prodi = mhs.prodi ?? "";
      const angkatan = mhs.angkatan ?? "";
      const id = mhs.id;

      const tr = document.createElement('tr');
      tr.innerHTML = `
        <td>${index + 1}</td>
        <td>${nim}</td>
        <td>${nama}</td>
        <td>${email}</td>
        <td>${prodi}</td>
        <td>${angkatan}</td>
        <td>
          <button class="btn btn-warning btn-sm btn-edit" data-id="${id}"><i class="fa fa-edit"></i></button>
          <button class="btn btn-danger btn-sm btn-delete" data-id="${id}"><i class="fa fa-trash"></i></button>
        </td>
      `;

      tbody.appendChild(tr);
    });

    // attach event handlers
    document.querySelectorAll('.btn-edit').forEach(btn => {
      btn.addEventListener('click', (e) => {
        const id = e.currentTarget.getAttribute('data-id');
        if (id) editMahasiswa(id);
      });
    });

    document.querySelectorAll('.btn-delete').forEach(btn => {
      btn.addEventListener('click', (e) => {
        const id = e.currentTarget.getAttribute('data-id');
        if (id) hapusMahasiswa(id);
      });
    });

  } catch (err) {
    console.error(err);
    tbody.innerHTML = `<tr><td colspan="7" class="text-center">Gagal mengambil data mahasiswa</td></tr>`;
  }
}

// ==========================================
// Search
// ==========================================
const searchInput = document.getElementById("searchInput");
if (searchInput) {
  let debounce;
  searchInput.addEventListener("keyup", function () {
    clearTimeout(debounce);
    debounce = setTimeout(() => loadMahasiswa(this.value), 300);
  });
}

// ==========================================
// Edit
// ==========================================
function editMahasiswa(id) {
  // open edit modal
  openMahasiswaModal('edit', id);
}

// ==========================================
// Hapus
// ==========================================
async function hapusMahasiswa(id) {
  if (!confirm("Yakin ingin menghapus mahasiswa ini?")) return;

  try {
    const response = await fetch(`${BASE_URL}/mahasiswa/${id}`, { method: 'DELETE' });
    if (!response.ok) {
      const text = await response.text().catch(() => '');
      throw new Error(`Status ${response.status} ${text}`);
    }
    // refresh list
    loadMahasiswa();
  } catch (err) {
    console.error(err);
    alert("Gagal menghapus data");
  }
}

// ==========================================
// Load Pertama
// ==========================================
loadMahasiswa();

// ==========================================
// Modal create/edit handlers
// ==========================================
const mahasiswaModalEl = document.getElementById('mahasiswaModal');
let mahasiswaModal;
if (mahasiswaModalEl) {
  mahasiswaModal = new bootstrap.Modal(mahasiswaModalEl, { keyboard: true });
}

document.getElementById('btnTambahMahasiswa')?.addEventListener('click', () => openMahasiswaModal('create'));

async function openMahasiswaModal(mode, id) {
  const title = document.getElementById('mahasiswaModalTitle');
  const saveBtn = document.getElementById('modalSaveBtn');
  const form = document.getElementById('formMahasiswaModal');

  // reset
  form.reset();
  document.getElementById('modalMahasiswaId').value = '';

  if (mode === 'create') {
    title.innerText = 'Tambah Mahasiswa';
    saveBtn.innerText = 'Simpan';
    saveBtn.onclick = async () => await submitMahasiswa('create');
    mahasiswaModal?.show();
    return;
  }

  // edit: load data
  title.innerText = 'Edit Mahasiswa';
  saveBtn.innerText = 'Update';
  try {
    const resp = await fetch(`${BASE_URL}/mahasiswa/${id}`);
    if (!resp.ok) throw new Error('Tidak dapat memuat data');
    const m = await resp.json();
    document.getElementById('modalMahasiswaId').value = m.id || '';
    document.getElementById('modalNim').value = m.nim || '';
    document.getElementById('modalNama').value = m.nama || '';
    document.getElementById('modalEmail').value = m.email || '';
    document.getElementById('modalProdi').value = m.prodi || '';
    document.getElementById('modalAngkatan').value = m.angkatan || '';

    saveBtn.onclick = async () => await submitMahasiswa('edit', id);
    mahasiswaModal?.show();
  } catch (err) {
    console.error(err);
    alert('Gagal memuat data mahasiswa');
  }
}

async function submitMahasiswa(mode, id) {
  const saveBtn = document.getElementById('modalSaveBtn');
  saveBtn.disabled = true;
  try {
    const payload = {
      nim: document.getElementById('modalNim').value,
      nama: document.getElementById('modalNama').value,
      email: document.getElementById('modalEmail').value,
      prodi: document.getElementById('modalProdi').value,
      angkatan: parseInt(document.getElementById('modalAngkatan').value, 10) || null,
    };

    let resp;
    if (mode === 'create') {
      resp = await fetch(`${BASE_URL}/mahasiswa`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(payload)
      });
    } else {
      resp = await fetch(`${BASE_URL}/mahasiswa/${id}`, {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(payload)
      });
    }

    if (!resp.ok) {
      const txt = await resp.text().catch(() => '');
      throw new Error(`Server error: ${resp.status} ${txt}`);
    }

    mahasiswaModal?.hide();
    loadMahasiswa();
  } catch (err) {
    console.error(err);
    alert('Gagal menyimpan data mahasiswa');
  } finally {
    saveBtn.disabled = false;
  }
}
