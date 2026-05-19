CREATE TABLE hotel (
                       id BIGSERIAL PRIMARY KEY,
                       nombre VARCHAR(100) NOT NULL,
                       direccion VARCHAR(150) NOT NULL,
                       ciudad VARCHAR(100) NOT NULL,
                       telefono VARCHAR(30),
                       correo VARCHAR(150) UNIQUE,
                       categoria INT,
                       estado VARCHAR(20),
                       fecha_creacion TIMESTAMP
);

CREATE TABLE usuario (
                         id BIGSERIAL PRIMARY KEY,
                         nombre_completo VARCHAR(120),
                         correo VARCHAR(150) UNIQUE NOT NULL,
                         password VARCHAR(200),
                         documento_identidad VARCHAR(50),
                         telefono VARCHAR(30),
                         fecha_nacimiento DATE,
                         cargo VARCHAR(50),
                         fecha_contratacion DATE,
                         rol VARCHAR(20),
                         hotel_id BIGINT REFERENCES hotel(id)
);

CREATE TABLE habitacion (
                            id BIGSERIAL PRIMARY KEY,
                            numero VARCHAR(20) NOT NULL,
                            tipo VARCHAR(20),
                            piso INT,
                            capacidad INT,
                            precio_por_noche NUMERIC(10,2) NOT NULL,
                            estado VARCHAR(20),
                            descripcion VARCHAR(255),
                            hotel_id BIGINT REFERENCES hotel(id)
);

CREATE TABLE reserva (
                         id BIGSERIAL PRIMARY KEY,
                         cliente_id BIGINT REFERENCES usuario(id),
                         empleado_id BIGINT REFERENCES usuario(id),
                         habitacion_id BIGINT REFERENCES habitacion(id),
                         fecha_check_in DATE NOT NULL,
                         fecha_check_out DATE NOT NULL,
                         numero_huespedes INT NOT NULL,
                         precio_total NUMERIC(10,2),
                         estado VARCHAR(20),
                         observaciones VARCHAR(255),
                         fecha_creacion TIMESTAMP
);

CREATE TABLE pago (
                      id BIGSERIAL PRIMARY KEY,
                      reserva_id BIGINT REFERENCES reserva(id),
                      monto NUMERIC(10,2) NOT NULL,
                      metodo_pago VARCHAR(20),
                      fecha_pago TIMESTAMP,
                      referencia VARCHAR(100),
                      estado VARCHAR(20)
);

CREATE TABLE factura (
                         id BIGSERIAL PRIMARY KEY,
                         numero_factura VARCHAR(50) UNIQUE,
                         reserva_id BIGINT REFERENCES reserva(id),
                         pago_id BIGINT REFERENCES pago(id),
                         cliente_id BIGINT REFERENCES usuario(id),
                         subtotal NUMERIC(10,2),
                         impuestos NUMERIC(10,2),
                         total NUMERIC(10,2),
                         fecha_emision TIMESTAMP,
                         detalle TEXT
);

CREATE TABLE servicio (
                          id BIGSERIAL PRIMARY KEY,
                          nombre VARCHAR(100) NOT NULL,
                          tipo VARCHAR(20),
                          descripcion VARCHAR(255),
                          precio NUMERIC(10,2),
                          hotel_id BIGINT REFERENCES hotel(id),
                          activo BOOLEAN DEFAULT TRUE
);

CREATE TABLE reserva_servicio (
                                  id BIGSERIAL PRIMARY KEY,
                                  reserva_id BIGINT REFERENCES reserva(id),
                                  servicio_id BIGINT REFERENCES servicio(id),
                                  cantidad INT,
                                  fecha_uso TIMESTAMP,
                                  subtotal NUMERIC(10,2)
);