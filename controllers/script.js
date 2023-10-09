const loginContainer = document.getElementById('login');
        const registroContainer = document.getElementById('registro');

        document.querySelector('.register-link a').addEventListener('click', function(event) {
            event.preventDefault();
            loginContainer.style.display = 'none';
            registroContainer.style.display = 'block';
        });

        document.querySelector('#registro-form .register-link a').addEventListener('click', function(event) {
            event.preventDefault();
            registroContainer.style.display = 'none';
            loginContainer.style.display = 'block';
        });


    


