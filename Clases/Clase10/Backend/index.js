// Dependencias a utilizar
const fs = require('fs');
const express = require('express');
const bodyParser = require('body-parser');
const cors = require('cors');

// Creamos nuestro backend usando el framework de express
const app = express();
// Especificamos a usar en nuestra maquina local
const PORT = 5000;
// Nombre del archivo que nos dará persistencia de datos
const FILENAME = 'Usuarios.json';

// Le especificamos al framework que se usara el parseo de tipo json y los cors
app.use(bodyParser.json());
app.use(cors());

// Base de datos de ejemplo
let dataStudents = [];

// Verificar y crear archivo si no existe
if (!fs.existsSync(FILENAME)) {
    fs.writeFileSync(FILENAME, JSON.stringify(dataStudents));
} else {
    // Si el archivo existe, cargar los datos
    const fileData = fs.readFileSync(FILENAME, 'utf8');
    dataStudents = JSON.parse(fileData);
}

// Función que ayuda a actualizar el contenido del archivo json
function updateDataFile() {
    fs.writeFileSync(FILENAME, JSON.stringify(dataStudents));
}

// Estructura para recibir peticiones:
// app = variable con la que creamos nuestro backend haciendo uso del framework express
// .Tipo de metodo = GET, POST, PUT, DELETE
// "/url" = Endpoint que se quiere consultar
// req = recibe los parametros que vienen por parte del cliente
// res = se encarga de responder al cliente

// Creando un endpoint sencillo que retorne un mensaje
app.get('/', (req, res) => {
    let saludo = {
        Saludo: "Hola mundo!"
    };
    res.json(saludo);
});

// Endpoint el cual retorna todos los estudiantes almacenados
app.get('/students', (req, res) => {
    res.json(dataStudents);
});

// Endpoint el cual retorna un estudiante en especifico a partir de su carnet
// /:carnet es un parametro el cual no conocemos su valor, es una manera dinamica de obtener valores
app.get('/students/:carnet', (req, res) => {
    // Obtenemos el carnet que viene en los parametros de la url
    const carnet = req.params.carnet;
    // Buscamos en la lista si existe algun objeto json con ese carnet, si no existe nos retorna null = false
    // y si encuentra algun objetos con este carnet nos retorna el objeto
    const student = dataStudents.find(student => student.carnet === carnet);
    if (!student) {
        // Si no se encuentra retornamos este mensaje
        res.status(404).send({ response: 'Elemento no encontrado' });
    } else {
        // Si encuentra al estudiante retorna el objeto json con su info
        res.json(student);
    }
});

// Endpoint en el cual guardamos un nuevo estudiante, la info se manda en el body en formato json
app.post('/students', (req, res) => {
    // Guardamos el cuerpo de la peticion
    const newStudent = req.body;
    // Agregamos el estudiante a la lista
    dataStudents.push(newStudent);
    updateDataFile();
    // Brindamos un mensaje de confirmacion
    res.status(201).send('Elemento creado correctamente');
});

// Endpoint en el cual recibimos los datos del usuario que se quiere loggear, se valida si el usuario existe o no
// en el array de usuarios y también se valida que su password sea correcto
app.post('/login', (req, res) => {
    const data = req.body;
    console.log(data)
    const student = dataStudents.find(student => {
        console.log(student.carnet)
        console.log(student.password)
        if (student.carnet === data.carnet && student.password === data.password) {
            return student
        }
    });
    if (!student) {
        const response = {
            success: false,
            user: null
        }
        res.status(404).send(response);
    } else {
        const response = {
            success: true,
            user: student
        }
        res.json(response);
    }
});

// Endpoint con el cual actualizaremos los atributos de un objeto, menos su carnet
app.put('/students/:carnet', (req, res) => {
    // Obtenemos el carnet del objeto que se va a actualizar
    const carnet = req.params.carnet;
    // Obtenemos el cuerpo de la peticion en el cual vienen los nuevos valores
    const updatedStudent = req.body;
    // Obtenemos el indice de la lista en donde se encuentra el objeto con el carnet
    const index = dataStudents.findIndex(student => student.carnet === carnet);
    // Si no existe el objeto nos retorna un -1
    if (index === -1) {
        res.status(404).send('Elemento no encontrado');
    } else {
        // Si se encontro el objeto, editamos sus atributos haciendo uso del indice
        dataStudents[index].nombre = updatedStudent.nombre;
        dataStudents[index].apellido = updatedStudent.apellido;
        dataStudents[index].edad = updatedStudent.edad;
        dataStudents[index].password = updatedStudent.password;
        updateDataFile();
        res.send('Elemento actualizado correctamente');
    }
});

// Endpoint con el cual se eliminar un estudiante en especifico
app.delete('/students/:carnet', (req, res) => {
    // Obtenemosel carnet del objeto que se va a actualizar
    const carnet = parseInt(req.params.carnet);
    // Obtenemos el indice de la lista en donde se encuentra el objeto con el carnet
    console.log(carnet)
    const index = dataStudents.findIndex(student => {
        console.log(student.carnet)
        if (student.carnet === carnet) {
            console.log("Elemento encontrado")
            return student
        }
    });
    if (index === -1) {
        res.status(404).send({ mensaje: 'Elemento no encontrado' });
    } else {
        // Eliminamos el objeto
        dataStudents.splice(index, 1);
        updateDataFile();
        res.send({ mensaje: 'Elemento eliminado correctamente' });
    }
});

// Iniciar el servidor en el puerto especificado
app.listen(PORT, () => {
    console.log(`Servidor escuchando en el puerto ${PORT}`);
});