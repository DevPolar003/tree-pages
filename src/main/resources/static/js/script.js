const form = document.querySelector("#account-form"); // find the form


form.addEventListener("submit", async (event) => { // when submit

    event.preventDefault(); // usually the browser by default submit the forms 

    const data = {
        name: form.name.value,
        email: form.email.value,
        password: form.password.value
    };

    const response = await fetch("/auth/register", {
        method: "POST",

        headers: {
            "Content-Type": "application/json"
        },


        body: JSON.stringify(data)

    });

    if (response.ok) {
        window.location.href = "/templates/login.html";
    }
});

