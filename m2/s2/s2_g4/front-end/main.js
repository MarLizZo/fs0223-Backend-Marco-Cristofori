class Registration {
    name;
    username;
    email;
    password;

    url = "http://localhost:8080/api/auth/register";

    constructor(username, name, email, password) {
        this.username = username;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    register() {
        data = {
            name: this.name,
            username: this.username,
            email: this.email,
            password: this.password,
        };
        fetch(urlReg, {
            method: "POST",
            body: JSON.stringify(data),
            headers: {
                "Content-Type": "application/json",
            },
        })
            .then((res) => console.log(res))
            .catch((err) => console.log(err));
    }
}

function login() {
    const url = "http://localhost:8080/api/auth/login";
    const username = document.getElementById("username");
    const pass = document.getElementById("pass");
    let infoH4 = document.getElementById("infos");
    const data = {
        username: username.value,
        password: pass.value,
    };
    fetch(url, {
        method: "POST",
        body: JSON.stringify(data),
        headers: {
            "Content-Type": "application/json",
        },
    })
        .then((res) => res.json())
        .then((data) => {
            console.log(data);
            infoH4.innerText = data.accessToken;
        })
        .catch((err) => console.log(err));
}

window.onload = () => {
    let btnR = document.getElementById("reg-btn");
    let btnL = document.getElementById("log-btn");

    if (btnR != null) {
        btnR.addEventListener("click", () => {
            const username = document.getElementById("username");
            const name = document.getElementById("name");
            const email = document.getElementById("email");
            const pass = document.getElementById("pass");
            reg = new Registration(
                username.value,
                name.value,
                email.value,
                pass.value
            );
            reg.register();
        });
    }

    if (btnL != null) {
        btnL.addEventListener("click", () => {
            login();
        });
    }
};
