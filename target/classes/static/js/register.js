document.getElementById('registration-form').addEventListener('submit', function(e) {
    e.preventDefault();

    const userRequest = {
        username: document.getElementById('register-username').value,
        password: document.getElementById('register-password').value
    };

    fetch('/register/', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(userRequest)
    })
        .then(response => {
            if (response.ok) {
                alert('Good! Go to /login');
            } else {
                alert(response);
            }
        })
        .catch(error => console.error('D’oh!:', error));
});