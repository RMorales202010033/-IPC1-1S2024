import React, { useState, useEffect, Fragment } from 'react';
import './Styles/Login.css';
import { useCookies } from 'react-cookie';
import { useNavigate } from "react-router-dom";
import { Link } from "react-router-dom";

function CreatePost() {
    // Se declaran los estados iniciales
    const [description, setDescription] = useState("");
    // Se declaran las cookies para acceder y removerlas en este caso
    const [cookies, setCookie, removeCookie] = useCookies(['usuario']);
    const [selectedImage, setSelectedImage] = useState('https://c4.wallpaperflare.com/wallpaper/764/505/66/baby-groot-4k-hd-superheroes-wallpaper-preview.jpg');
    const [base64Image, setBase64Image] = useState('');
    const navigate = useNavigate();

    // Este método se encarga de hacer logout
    const handleLogout = () => {
        removeCookie('usuario');
        navigate('/login')

    };

    // Este método se llama cuando se carga una nueva imagen al navegador
    const handleImageChange = (event) => {
        // Evita que se recargue la página
        event.preventDefault();
        // Agarramos el primer archivo
        const file = event.target.files[0];
        if (file) {
            const reader = new FileReader();
            reader.onload = () => {
                // Guardamos la imagen para que se muestre en la vista previa
                setSelectedImage(URL.createObjectURL(file));
                // Guardamos la base 64 para mandarla al backend
                setBase64Image(reader.result);
            };
            reader.readAsDataURL(file);
        }
    };

    const handlePost = () => {
        // Accedemos a las cookies
        const userName = cookies.usuario;
        // Creamos el objeto que se va a mandar
        const data = {
            description: description,
            image: base64Image,
            name: `${userName.nombre} ${userName.apellido}`
        }
        // console.log(data)
        // Este método se encarga de comunicarse con el backend con un endpoint específico, en este caso /createPost
        fetch(`http://localhost:5000/createPost`, {
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
                alert(res.response)
                // Limpiamos los estados
                setDescription("")
                setSelectedImage('https://c4.wallpaperflare.com/wallpaper/764/505/66/baby-groot-4k-hd-superheroes-wallpaper-preview.jpg')
            })
            .catch((error) => console.error(error));
    };

    return (
        <Fragment>
            <div style={{ display: "flex", alignItems: "center", height: "10vh", width: "100%", top: "0", backgroundColor: "#212529" }}>
                <div style={{ display: "flex", alignItems: "center", height: "10vh", width: "50%", top: "0", paddingLeft: "5%" }}>
                    <ul style={{ listStyleType: "none", display: "flex", padding: 0, height: "100%", alignItems: "center", margin: "0px" }}>
                        <li style={{ color: "white", marginRight: "35px" }}>
                            {/* El link nos ayuda a navegar entre rutas, igual al navigate */}
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
                <div style={{ display: "flex", alignItems: "center", height: "10vh", width: "50%", top: "0", flexDirection: "row-reverse", paddingRight: "5%" }}>
                    <button className="btn btn-outline-info" onClick={handleLogout}>
                        Logout
                    </button>
                </div>
            </div>
            <div style={{ display: "flex", alignItems: "center", height: "90vh", width: "100%", top: "10", paddingBottom: "5%", paddingTop: "5%" }}>
                <div className="container-fluid h-100" style={{ marginRight: "20%", marginLeft: "20%", borderRadius: "25px", backgroundColor: "#172B6B", display: "flex", padding: "5%", color: "white", flexDirection: "column" }}>
                    <h1>Description:</h1>
                    <textarea className="form-control" rows="5" style={{ resize: "none", marginTop: "3%" }} onChange={(e) => setDescription(e.target.value)} value={description}>
                    </textarea>
                    <div style={{ display: "flex", justifyContent: "center", alignContent: "center", marginTop: "5%", flexDirection: "column" }}>
                        <label htmlFor="file-upload" className="btn btn-outline-warning" style={{ fontSize: "19px", width: "100%", height: "auto", display: "flex", alignItems: "center", justifyContent: "center" }}>
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" className="bi bi-images" viewBox="0 0 16 16" style={{ marginRight: "1%" }}>
                                <path d="M4.502 9a1.5 1.5 0 1 0 0-3 1.5 1.5 0 0 0 0 3" />
                                <path d="M14.002 13a2 2 0 0 1-2 2h-10a2 2 0 0 1-2-2V5A2 2 0 0 1 2 3a2 2 0 0 1 2-2h10a2 2 0 0 1 2 2v8a2 2 0 0 1-1.998 2M14 2H4a1 1 0 0 0-1 1h9.002a2 2 0 0 1 2 2v7A1 1 0 0 0 15 11V3a1 1 0 0 0-1-1M2.002 4a1 1 0 0 0-1 1v8l2.646-2.354a.5.5 0 0 1 .63-.062l2.66 1.773 3.71-3.71a.5.5 0 0 1 .577-.094l1.777 1.947V5a1 1 0 0 0-1-1z" />
                            </svg>
                            {" Choose an image to post"}
                        </label>
                        <input onChange={handleImageChange} id="file-upload" type="file" accept="image/*" style={{ display: "none" }} />
                    </div>
                    <div style={{ display: "flex", alignItems: "center", justifyContent: "center", width: "100%", maxHeight: "30rem", height: "35%", marginTop: "5%" }}>
                        <div style={{ display: "flex", alignItems: "center", justifyContent: "center", width: "100%", height: "100%", maxHeight: "30rem", maxWidth: "25rem" }}>
                            {selectedImage && <img src={selectedImage} alt="Selected" style={{ objectFit: "cover", width: "22rem", height: "12rem" }} />}
                        </div>
                    </div>
                    <div style={{ width: "100%", marginTop: "5%", display: "flex", alignItems: "center", justifyContent: "center" }}>
                        <button type="button" className="btn btn-outline-light" onClick={handlePost}>
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" className="bi bi-upload" viewBox="0 0 16 16">
                                <path d="M.5 9.9a.5.5 0 0 1 .5.5v2.5a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1v-2.5a.5.5 0 0 1 1 0v2.5a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2v-2.5a.5.5 0 0 1 .5-.5" />
                                <path d="M7.646 1.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1-.708.708L8.5 2.707V11.5a.5.5 0 0 1-1 0V2.707L5.354 4.854a.5.5 0 1 1-.708-.708z" />
                            </svg>
                            {" Post"}
                        </button>
                    </div>
                </div>
            </div>
        </Fragment>
    );
}

export default CreatePost;