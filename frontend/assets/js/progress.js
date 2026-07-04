async function loadProgress() {
  try {
    const response = await fetch(BASE_URL + "/progress");

    const list = await response.json();

    const tbody = document.getElementById("progressTable");

    tbody.innerHTML = "";

    if (list.length === 0) {
      tbody.innerHTML = `
                <tr>
                    <td colspan="8" class="text-center">
                        Belum ada data progress.
                    </td>
                </tr>`;

      return;
    }

    list.forEach((progress, index) => {
      let badge = "";

      if (progress.status === "PROSES") {
        badge = `<span class="badge bg-warning">PROSES</span>`;
      } else if (progress.status === "ACC") {
        badge = `<span class="badge bg-success">ACC</span>`;
      } else {
        badge = `<span class="badge bg-danger">REVISI</span>`;
      }

      tbody.innerHTML += `
                <tr>
                    <td>${index + 1}</td>
                    <td>${progress.skripsi.mahasiswa.nama}</td>
                    <td>${progress.skripsi.judul}</td>
                    <td>${progress.bab}</td>

                    <td>
                        <div class="progress">
                            <div class="progress-bar bg-success"
                                style="width:${progress.persentase}%">
                                ${progress.persentase}%
                            </div>
                        </div>
                    </td>

                    <td>${badge}</td>

                    <td>${progress.tanggal}</td>

                    <td>
                        <a href="detail.html?id=${progress.id}"
                           class="btn btn-primary btn-sm">
                            <i class="fa fa-eye"></i>
                            Detail
                        </a>
                    </td>

                </tr>
            `;
    });
  } catch (e) {
    console.error(e);

    alert("Gagal mengambil data progress.");
  }
}
