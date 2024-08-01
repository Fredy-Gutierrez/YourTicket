import React from "react";
import { Link } from "react-router-dom";

const Footer = () => {
  return (
    <footer className="bg-dark text-white py-3 text-center position-absolute w-100 bottom-0">
      <div className="container d-flex justify-content-between align-items-center">
        <p className="mb-0">
          &copy; 2024 YourTicket. Todos los derechos reservados.
        </p>
        <div className="d-flex">
          <Link
            to="/acerca"
            className="btn btn-link nav-link mx-2"
            style={{ borderRadius: "5px" }}
          >
            Acerca de
          </Link>
          <Link
            to="/contacto"
            className="btn btn-link nav-link mx-2"
            style={{ borderRadius: "5px" }}
          >
            Contacto
          </Link>
        </div>
      </div>
    </footer>
  );
};

export default Footer;
