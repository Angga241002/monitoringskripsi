const form = document.getElementById("loginForm");

form.addEventListener("submit", async (e) => {
  e.preventDefault();

  const username = document.getElementById("username").value;
  const password = document.getElementById("password").value;

  try {
    const response = await fetch(BASE_URL + "/login", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        username,
        password,
      }),
    });

    const result = await response.json();

    if (!result.success) {
      alert(result.message);
      return;
    }

    localStorage.setItem("user", JSON.stringify(result));

    if (result.role === "DOSEN") {
      window.location.href = "pages/dosen/dashboard.html";
    } else {
      window.location.href = "pages/mahasiswa/dashboard.html";
    }
  } catch (err) {
    console.log(err);
    alert("Tidak dapat terhubung ke server.");
  }
});
