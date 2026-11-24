CREATE DATABASE IF NOT EXISTS bd_supermercado;
USE bd_supermercado;

CREATE TABLE categoria (
    id_categoria INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL UNIQUE,
    descripcion VARCHAR(150)
);

CREATE TABLE proveedor (
    id_proveedor INT AUTO_INCREMENT PRIMARY KEY,
    nit VARCHAR(20) NOT NULL UNIQUE,
    razon_social VARCHAR(100) NOT NULL,
    telefono VARCHAR(20),
    rubro VARCHAR(50)
);

CREATE TABLE producto (
    id_producto INT AUTO_INCREMENT PRIMARY KEY,
    codigo VARCHAR(20) NOT NULL UNIQUE,
    nombre VARCHAR(100) NOT NULL,
    stock_actual INT NOT NULL DEFAULT 0,
    stock_minimo INT NOT NULL DEFAULT 5,
    id_categoria INT NOT NULL,
    id_proveedor INT NOT NULL,
    FOREIGN KEY (id_categoria) REFERENCES categoria(id_categoria),
    FOREIGN KEY (id_proveedor) REFERENCES proveedor(id_proveedor)
);

CREATE TABLE entrada (
    id_entrada INT AUTO_INCREMENT PRIMARY KEY,
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    cantidad INT NOT NULL,
    observacion VARCHAR(150),
    id_producto INT NOT NULL,
    id_proveedor INT NOT NULL,
    FOREIGN KEY (id_producto) REFERENCES producto(id_producto),
    FOREIGN KEY (id_proveedor) REFERENCES proveedor(id_proveedor)
);

CREATE TABLE salida (
    id_salida INT AUTO_INCREMENT PRIMARY KEY,
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    cantidad INT NOT NULL,
    motivo VARCHAR(100),
    id_producto INT NOT NULL,
    FOREIGN KEY (id_producto) REFERENCES producto(id_producto)
);

CREATE TABLE movimiento (
    id_movimiento INT AUTO_INCREMENT PRIMARY KEY,
    tipo_movimiento VARCHAR(20) NOT NULL,
    cantidad INT NOT NULL,
    stock_resultante INT NOT NULL,
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    id_producto INT NOT NULL,
    FOREIGN KEY (id_producto) REFERENCES producto(id_producto)
);