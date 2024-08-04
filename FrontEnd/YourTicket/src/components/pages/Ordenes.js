import React, { useState, useEffect } from "react";
import { getOrders } from "../../services/order-service";
import {Link} from "react-router-dom";

const Ordenes = () => {
  const userData = JSON.parse(localStorage.getItem("userData"));

  const [orders, setOrders] = useState([])
  useEffect(() => { 
    const load= async () => {
        const response = await getOrders(userData.userID);
        setOrders(response);
    };
    load()
  }, [userData])

  return (
    <div className="container mt-5">
      <h1>Ordenes</h1>
      {
        orders.map(order => (
          <div class="card mt-3">
            <div class="card-header">
              {order.eventName} | Zona: {order.zoneName} | Fila: {order.rowName} | Asiento: {order.seatNumber}
            </div>
            <div class="card-body">
              <h5 class="card-title">{order.ticketPrice}MXN {order.paymentMethod}</h5>
              <p class="card-text">{order.information}</p>
              <Link to={`/editarorden/${order.orderID}`} className="btn btn-primary btn-sm btn-card"> Regalar </Link>
            </div>
          </div>
        ))
      }
    </div>
  );
};

export default Ordenes;
