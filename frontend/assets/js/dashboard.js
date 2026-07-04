document.addEventListener("DOMContentLoaded", () => {
  console.log("Dashboard Loaded");

  loadDashboard();
});

async function loadDashboard() {
  try {
    const response = await fetch(BASE_URL + "/dashboard/dosen");

    console.log(response.status);

    if (!response.ok) {
      throw new Error("API Error");
    }

    const data = await response.json();

    console.log("DATA =", data);

    document.querySelector("#totalSkripsi").textContent = data.totalSkripsi;
    document.querySelector("#totalProgress").textContent = data.totalProgress;
    document.querySelector("#totalAcc").textContent = data.totalAcc;
    document.querySelector("#totalRevisi").textContent = data.totalRevisi;
    document.querySelector("#totalProses").textContent = data.totalProses;
  } catch (err) {
    console.error(err);
  }
}
