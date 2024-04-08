import React, { useState } from 'react';
import './Styles/Login.css';
import { useCookies } from 'react-cookie';
import { useNavigate } from "react-router-dom";

function Login() {
    // Creación de los estados de la pantalla
    const [carnet, setCarnet] = useState('');
    const [password, setPassword] = useState('');
    // Creación de la cookie que se usará
    const [cookies, setCookie] = useCookies(['usuario']);
    // Creación del encargado de navegar entre las distintas rutas que tiene nuestro Router
    const navigate = useNavigate();

    // Este método se encarga de comunicarse con nuestro backend para validar si las credenciales son correctas.
    const handleSubmit = (event) => {
        // Evita la recarga de nuestro sitio web
        event.preventDefault();
        const data = {
            carnet: parseInt(carnet, 10),
            password: password
        }
        // Este método se encarga de comunicarse con el backend con un endpoint específico, en este caso /login
        fetch(`http://localhost:5000/login`, {
            // Se especifica el tipo de método
            method: "POST",
            // Se parsea a json el cuerpo que se mandará
            body: JSON.stringify(data),
            // Se agregan los encabezados
            headers: {
                "Content-Type": "application/json",
            },
        })
            // Se obtiene la respuesta y se pasa a json
            .then((response) => response.json())
            // Una vez se tiene la respuesta en json se realizará lo siguiente
            .then((res) => {
                // Imprimimos en consola la respuesta
                console.log(res)
                // Validamos si las credenciales son correctas
                if (res.success) {
                    // De la respuesta que mandó el backend guardamos únicamente el valor del atributo user
                    const dataUser = res.user;
                    // Mostramos el nombre y apellido del usuario
                    alert(`Welcome: ${dataUser.nombre} ${dataUser.apellido}`)
                    // Guardamos en las cookies lo que mandó el backend
                    setCookie('usuario', dataUser);
                    // Navegamos a la siguiente ruta que está en nuestro router
                    navigate('/admin')
                } else {
                    // Si las credenciales están mal se muestra el siguiente mensaje.
                    alert(`Email and/or password incorrect.`)
                }
                // Se limpian los estados
                setCarnet("")
                setPassword("")
            })
            .catch((error) => console.error(error));
    };

    return (
        <div className="login-background">
            <div className="container-fluid h-100">
                <div className="row align-items-center h-100">
                    <div className="col-md-6 mx-auto">
                        <div className="card">
                            <div className="card-body">
                                <h2 className="card-title text-center mb-4">Inicio de Sesión</h2>
                                <form onSubmit={handleSubmit} className='form-signin w-100 m-auto'>
                                    <div className="form-floating" style={{ width: "100%" }}>
                                        <input
                                            type="number"
                                            className="form-control"
                                            id="floatingInput"
                                            placeholder="202400000"
                                            onChange={(e) => setCarnet(e.target.value)}
                                            value={carnet}
                                        />
                                        <label htmlFor="floatingInput">Carnet</label>
                                    </div>
                                    <div className="form-floating" style={{ width: "100%" }}>
                                        <input
                                            type="password"
                                            className="form-control"
                                            id="floatingPassword"
                                            placeholder="Password"
                                            onChange={(e) => setPassword(e.target.value)}
                                            value={password}
                                        />
                                        <label htmlFor="floatingPassword">Password</label>
                                    </div>
                                    <div className="text-center">
                                        <button type="submit" className="btn btn-outline-primary btn-lg">Iniciar Sesión</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Login;
