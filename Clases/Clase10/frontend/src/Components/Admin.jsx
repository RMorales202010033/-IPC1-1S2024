import React, { useState, useEffect } from 'react';
import { Modal, Button } from 'react-bootstrap';
import './Styles/Login.css';

function Admin() {
    // Se declaran los estados iniciales
    const [users, setUsers] = useState([]);
    const [selectedUser, setSelectedUser] = useState(null);
    const [validarEliminacion, setValidarEliminacion] = useState(false);

    // Este método se encarga de ejecutarse cuando la página se termine de renderizar o cargar en otras palabras
    // También se ejecuta cuando el estado validarEliminacion tiene algún cambio, es por eso que de último entre los 
    // corchetes se pone ese estado, para que monitoree si ese estado tiene un cambio de valor
    useEffect(() => {
        // Nos comunicamos con el backend en el endpoint especificado
        fetch(`http://localhost:5000/students`, {
            method: "GET",
        })
            .then((response) => response.json())
            .then((res) => {
                // Imprimimos la respuesta
                console.log(res)
                // Guardamos en un estado la respuesta que en este caso es un array de objetos json
                setUsers(res);
            })
            .catch((error) => console.error(error));
    }, [validarEliminacion]);

    // Este método se encarga de eliminar un usuario en específico
    const deleteUser = (carnet) => {
        // Nos comunicamos con el backend en el endpoint especificado para eliminar un usario en específico
        fetch(`http://localhost:5000/students/${carnet}`, {
            method: "DELETE",
            headers: {
                "Content-Type": "application/json"
            }
        })
            .then(response => response.json())
            .then(res => {
                // Mostramos el mensaje que manda el backend
                alert(res.mensaje)
                // Cambiamos el estado de validarEliminacion para que el useEffect se ejecute de nuevo
                setValidarEliminacion(() => !validarEliminacion)
            })
            .catch(error => console.error("Error al eliminar el usuario:", error));
    };


    const viewUser = (user) => {
        setSelectedUser(user);
    };

    const handleClose = () => {
        setSelectedUser(null);
    };

    return (
        <div style={{ display: "flex", alignItems: "center", height: "100vh", width: "100%" }}>
            <div className="table-container">
                <table className="table table-bordered text-center">
                    <thead className="table-dark">
                        <tr>
                            <th>Carnet</th>
                            <th>Nombre</th>
                            <th>Apellido</th>
                            <th>Edad</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        {users.map(user => (
                            <tr key={user.carnet}>
                                <td>{user.carnet}</td>
                                <td>{user.nombre}</td>
                                <td>{user.apellido}</td>
                                <td>{user.edad}</td>
                                <td>
                                    <button className="btn btn-outline-danger" onClick={() => deleteUser(user.carnet)} style={{marginRight:"5%"}}>
                                        Eliminar
                                    </button>
                                    <button className="btn btn-outline-warning" onClick={() => viewUser(user)}>Ver</button>
                                </td>
                            </tr>
                        ))}
                    </tbody>
                </table>

                {selectedUser && (
                    <Modal show={true} onHide={handleClose}>
                        <Modal.Header closeButton>
                            <Modal.Title>Detalles del Usuario</Modal.Title>
                        </Modal.Header>
                        <Modal.Body>
                            <p><strong>Carnet:</strong> {selectedUser.carnet}</p>
                            <p><strong>Nombre:</strong> {selectedUser.nombre}</p>
                            <p><strong>Apellido:</strong> {selectedUser.apellido}</p>
                            <p><strong>Edad:</strong> {selectedUser.edad}</p>
                        </Modal.Body>
                        <Modal.Footer>
                            <Button variant="secondary" onClick={handleClose}>
                                Cerrar
                            </Button>
                        </Modal.Footer>
                    </Modal>
                )}
            </div>
        </div>
    );
}

export default Admin;