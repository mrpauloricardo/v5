const loginContainer = document.getElementById('loginContainer');
const registerContainer = document.getElementById('registerContainer');
const showRegister = document.getElementById('showRegister');
const showLogin = document.getElementById('showLogin');
const loginForm = document.getElementById('loginForm');
const registerForm = document.getElementById('registerForm');
const loginMessage = document.getElementById('loginMessage');
const registerMessage = document.getElementById('registerMessage');

// Função para alterar o título
function changeTitle(title) {
    document.title = title;
}

showRegister.addEventListener('click', (e) => {
    e.preventDefault();
    loginContainer.style.display = 'none';
    registerContainer.style.display = 'block';
    changeTitle('Registro');  // Alterando o título para Registro
});

showLogin.addEventListener('click', (e) => {
    e.preventDefault();
    registerContainer.style.display = 'none';
    loginContainer.style.display = 'block';
    changeTitle('Login');  // Alterando o título para Login
});

loginForm.addEventListener('submit', (e) => {
    e.preventDefault();
    const email = document.getElementById('loginEmail').value;
    const password = document.getElementById('loginPassword').value;
    console.log('Login:', { email, password });
    loginMessage.textContent = `Tentativa de login com email: ${email}`;
});

registerForm.addEventListener('submit', (e) => {
    e.preventDefault();
    const username = document.getElementById('registerUsername').value;
    const email = document.getElementById('registerEmail').value;
    const password = document.getElementById('registerPassword').value;
    console.log('Registro:', { username, email, password });
    registerMessage.textContent = `Tentativa de registro com username: ${username} e email: ${email}`;
});
