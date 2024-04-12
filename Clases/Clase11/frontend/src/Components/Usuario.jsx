import React, { useState, useEffect, Fragment } from 'react';
import './Styles/Login.css';
import { useCookies } from 'react-cookie';
import { useNavigate } from "react-router-dom";
import { Link } from "react-router-dom";

function Usuario() {
    // Se declaran los estados iniciales
    const [posts, setPosts] = useState([]);
    // Se declaran las cookies, aunque no se usen algunos, se deben poner, sino tira error y no reconoce el removeCookie 
    const [cookies, setCookie, removeCookie] = useCookies(['usuario']);
    const navigate = useNavigate();

    // Este método se encarga de ejecutarse cuando la página se termine de renderizar o cargar en otras palabras
    useEffect(() => {
        // Nos comunicamos con el backend en el endpoint especificado
        fetch(`http://localhost:5000/getPosts`, {
            method: "GET",
        })
            .then((response) => response.json())
            .then((res) => {
                // Imprimimos la respuesta
                console.log(res)
                // Guardamos en un estado la respuesta que en este caso es un array de objetos json y antes de guardar el array
                // invertimos la lista
                setPosts(res.reverse());
            })
            .catch((error) => console.error(error));
    }, []);

    // Este método se encarga de hacer logout
    const handleLogout = () => {
        removeCookie('usuario');
        navigate('/login')
    };

    return (
        <Fragment>
            <div style={{ display: "flex", alignItems: "center", height: "10vh", width: "100%", top: "0", backgroundColor: "#212529" }}>
                <div style={{ display: "flex", alignItems: "center", height: "10vh", width: "50%", top: 0, paddingLeft: "5%" }}>
                    <ul style={{ listStyleType: "none", display: "flex", padding: 0, height: "100%", alignItems: "center", margin: "0px" }}>
                        <li style={{ color: "white", marginRight: "35px" }}>
                            {/* El link nos ayuda a navegar entre componentes, parecido al navigate */}
                            <Link style={{ color: "white", textDecoration: "none" }} to="/user">
                                Home
                            </Link>
                        </li>
                        <li style={{ color: "white" }}>
                            <Link style={{ color: "white", textDecoration: "none" }} to="/createPost">
                                Create post
                            </Link>
                        </li>
                    </ul>
                </div>
                <div style={{ display: "flex", alignItems: "center", height: "10vh", width: "50%", top: 0, flexDirection: "row-reverse", paddingRight: "5%" }}>
                    <button className="btn btn-outline-info" onClick={handleLogout}>
                        Logout
                    </button>
                </div>
            </div>
            <div style={{ height: "auto", width: "100%", top: "10", paddingTop: "5%", paddingRight: "20%", paddingLeft: "20%" }}>
                {
                    posts.map((item, index) => (
                        <div className="card mb-3 mb-5" key={index}>
                            <img className="card-img-top" src={item.image} alt="Card image cap" />
                            <div className="card-body">
                                <h5 className="card-title">{item.name}</h5>
                                <p className="card-text">{item.description}</p>
                            </div>
                        </div>
                    ))
                }
            </div>
        </Fragment>
    );
}

export default Usuario;