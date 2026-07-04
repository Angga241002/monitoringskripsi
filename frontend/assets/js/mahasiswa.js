// ==========================================
// Cek Login
// ==========================================
const user = JSON.parse(localStorage.getItem("user"));

if (!user) {
  window.location.href = "../../login.html";
}

// ==========================================
// Load Sidebar
// ==========================================
fetch("../../components/sidebar-dosen.html")
  .then((res) => res.text())
  .then((html) => {
    document.getElementById("sidebar-container").innerHTML = html;

    const menu = document.getElementById("menu-mahasiswa");

    if (menu) {
      menu.classList.add("active");
    }

    const logoutBtn = document.getElementById("logoutBtn");

    if (logoutBtn) {
      logoutBtn.addEventListener("click", logout);
    }
  });

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
  let url = BASE_URL + "/mahasiswa";

  if (keyword !== "") {
    url += "/search?keyword=" + encodeURIComponent(keyword);
  }

  try {
    const response = await fetch(url);

    const data = await response.json();

    const tbody = document.getElementById("tableMahasiswa");

    tbody.innerHTML = "";

    if (data.length === 0) {
      tbody.innerHTML = `
                <tr>
                    <td colspan="7" class="text-center">
                        Tidak ada data mahasiswa
                    </td>
                </tr>
            `;

      return;
    }

    data.forEach((mhs, index) => {
      tbody.innerHTML += `

                <tr>

                    <td>${index + 1}</td>

                    <td>${mhs.nim ?? ""}</td>

                    <td>${mhs.nama ?? ""}</td>

                    <td>${mhs.email ?? ""}</td>

                    <td>${mhs.prodi ?? ""}</td>

                    <td>${mhs.angkatan ?? ""}</td>

                    <td>

                        <button
                            class="btn btn-warning btn-sm"
                            onclick="editMahasiswa(${mhs.id})">

                            <i class="fa fa-edit"></i>

                        </button>

                        <button
                            class="btn btn-danger btn-sm"
                            onclick="hapusMahasiswa(${mhs.id})">

                            <i class="fa fa-trash"></i>

                        </button>

                    </td>

                </tr>

            `;
    });
  } catch (err) {
    console.error(err);

    alert("Gagal mengambil data mahasiswa");
  }
}

// ==========================================
// Search
// ==========================================
const searchInput = document.getElementById("searchInput");

searchInput.addEventListener("keyup", function () {
  loadMahasiswa(this.value);
});

// ==========================================
// Edit
// ==========================================
function editMahasiswa(id) {
  window.location.href = "edit-mahasiswa.html?id=" + id;
}

// ==========================================
// Hapus
// ==========================================
async function hapusMahasiswa(id) {
  if (!confirm("Yakin ingin menghapus mahasiswa ini?")) {
    return;
  }

  try {
    const response = await fetch(
      BASE_URL + "/mahasiswa/" + id,

      {
        method: "DELETE",
      },
    );

    if (!response.ok) {
      throw new Error();
    }

    loadMahasiswa();
  } catch (err) {
    alert("Gagal menghapus data");
  }
}

// ==========================================
// Load Pertama
// ==========================================
loadMahasiswa();
