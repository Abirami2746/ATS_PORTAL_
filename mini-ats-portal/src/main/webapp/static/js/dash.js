function logout() {
    alert("You have been logged out!");
    window.location.href = "log.html";
}

function loadData() {
    fetch("data.json")
        .then(response => {
            if (!response.ok) {
                throw new Error("HTTP error " + response.status);
            }
            return response.json();
        })
        .then(data => {
            document.getElementById("result").innerHTML =
                "Welcome, " + data.name;
        })
        .catch(error => {
            console.error("Error:", error);
            document.getElementById("result").innerHTML =
                "Failed to load data";
        });
}
