import React, { useState, useEffect } from "react";
import { updateOrder } from "../../services/order-service";
import {useParams, useNavigate} from "react-router-dom";
import Swal from "sweetalert2";

const EditarOrden = () => {
  const params = useParams();
  const orderId = params.orderid;
  const navigate = useNavigate();

  const [username, setUsername] = useState("");

  const handleSubmit = async (event) => {
    event.preventDefault();
    
    try {
        if (username.length < 2) {
          Swal.fire({
            icon: "error",
            title: "Oops...",
            text: "Nombre de usuario invalido!"
          });
          return;
        }

        const response = await updateOrder(orderId, username);
        if(response.status === 200 && response.data != null){
            Swal.fire({
                title: 'Exito',
                text: 'Se ha camiado la orden',
                icon: 'success',
                showConfirmButton: false,
                timer: 2000
            })
            .then(function (result) {
                if (result.dismiss === Swal.DismissReason.timer) {
                    navigate("/ordenes");
                }
            })
        }else{
            Swal.fire({
                icon: "error",
                title: "Oops...",
                text: "Ha ocurrido un error!"
            });
        }
    } catch (error) {
        console.error("Error during order creation:", error);
        Swal.fire({
            icon: "error",
            title: "Oops...",
            text: "Ha ocurrido un error!"
        });
    }
  };

  return (
    <div className="container">

        <div className="col-md-12  d-flex justify-content-center">
            <h1>Regalar Boleto  </h1>
        </div>

        <div className="col-md-12 d-flex justify-content-center">
            <form className="col-md-10"  onSubmit={handleSubmit}>
                <div className="form-group p-3">
                    <label for="rows">Ingrese el nombre de usuario del destinatario</label>
                    <input type="text"  className="form-control" value={username} 
                    onChange={(e) => setUsername(e.target.value)} required/>
                </div>
                <button type="submit" className="btn btn-primary ">Enviar</button>
            </form>
        </div>
        
      </div>
  );
};

export default EditarOrden;