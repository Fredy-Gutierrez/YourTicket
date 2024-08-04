import React, { useState, useEffect } from "react";
import { getEvent, getZones, getRows, getSeats } from "../../services/eventos-service";
import { createOrder } from "../../services/order-service";
import {useParams, useNavigate} from "react-router-dom";
import Swal from "sweetalert2";

const payMethods = [
    { value: 'EFECTIVO', label: 'Efectivo' },
    { value: 'TARJETA', label: 'Tarjeta' },
    { value: 'TRANSERENCIA', label: 'Transferencia' },
    { value: 'PAYPAL', label: 'Paypal' }
]


const Buy = () => {
    const params = useParams();
    const eventId = params.eventid;
    const userData = JSON.parse(localStorage.getItem("userData"));
    const navigate = useNavigate();

    const [event, setEvent] = useState([])
    const [zones, setZones] = useState([])
    const [rows, setRows] = useState([])
    const [seats, setSeats] = useState([])
    const [zoneSelected, setZoneSelected] = useState([])
    const [rowSelected, setRowSelected] = useState([])
    const [seatSelected, setSeatSelected] = useState([])
    const [paySelected, setPaySelected] = useState([])

    useEffect(() => { 
        const loadEvent= async () => {
            const response = await getEvent(eventId);
            setEvent(response);
        };
        
        const loadAll= async () => {
            const aZones = await getZones(eventId);
            if(aZones.length < 1)
                return;
            setZones(aZones);
            setZoneSelected(aZones[0])

            const aRows = await getRows(aZones[0].zoneID);
            if(aRows.length < 1)
                return;
            setRows(aRows);
            setRowSelected(aRows[0])

            const aSeat = await getSeats(aRows[0].rowID);
            setSeats(aSeat);
            setSeatSelected(aSeat[0])

            setPaySelected(payMethods[0])
        }
        loadEvent()
        loadAll()
    }, [eventId])

    const changeZone = async (event) => {
		const selectedZone = event.target.value;
        const zone = zones.find(e => Number.parseInt(e.zoneID) === Number.parseInt(selectedZone))
        setZoneSelected(zone)

		const rows = await getRows(selectedZone)
        setRows(rows);
        setRowSelected(rows[0])

        if(rows.length < 1)
            return;

        const aSeat = await getSeats(rows[0].rowID);
        setSeats(aSeat);
        setSeatSelected(aSeat[0])
	}

    const changeRow = async (event) => {
        const selectedRow = event.target.value
        const row = rows.find(e => Number.parseInt(e.rowID) === Number.parseInt(selectedRow))
        setRowSelected(row)

		const response = await getSeats(selectedRow)
        setSeats(response)
        setSeatSelected(response[0])
    }

    const changeSeat = async (event) => {
        const selectedRow = event.target.value
        const seat = seats.find(e => Number.parseInt(e.seatID) === Number.parseInt(selectedRow))
        setSeatSelected(seat)
    }

    const changePayMethod = async (event) => {
        const selectedPay = event.target.value
        const pay = payMethods.find(e => e.value === selectedPay)
        setPaySelected(pay)
    }

    const handleSubmit = async (event) => {
        event.preventDefault();
        try {
            const response = await createOrder(userData.userID, seatSelected.seatID, paySelected.value);
            if(response.status === 200 && response.data != null){
                Swal.fire({
                    title: 'Exito',
                    text: 'Se registrado la orden',
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
            <h1>Evento {event.eventName}  </h1>
        </div>
        
        <div className="col-md-12  d-flex justify-content-end  align-items-center">
            <h2>Precio Final: </h2>
            <h3>{zoneSelected.ticketPrice} MXN</h3>
        </div>

        <div className="col-md-12 d-flex justify-content-center">
            <form className="col-md-10"  onSubmit={handleSubmit}>

                <div className="form-group p-3">
                    <label for="zone">Elija la zona de preferencia</label>
                    <select value={zoneSelected.zoneID} onChange={changeZone} className="form-select" id="zone">
                        {
                            zones.map(z => (
                                <option key={z.zoneID} value={z.zoneID}>{z.zoneName}</option>
                            ))
                        }
                    </select>
                </div>
                <div className="form-group p-3">
                    <label for="rows">Elija la fila de preferencia</label>
                    <select value={rowSelected.rowID} onChange={changeRow} className="form-select" id="zone">
                        {
                            rows.map(z => (
                                <option key={z.rowID} value={z.rowID}>{z.rowName}</option>
                            ))
                        }
                    </select>
                </div>
                <div className="form-group p-3">
                    <label for="rows">Elija el asiento de preferencia</label>

                    <select value={seatSelected.seatID} onChange={changeSeat} className="form-select" id="zone">
                        {
                            seats.map(z => (
                                <option key={z.seatID} value={z.seatID}>{z.seatNumber}</option>
                            ))
                        }
                    </select>
                </div>
                <div className="form-group p-3">
                    <label for="rows">Elija el metodo de pago</label>

                    <select value={paySelected.value} onChange={changePayMethod} className="form-select" id="zone">
                        {
                            payMethods.map(z => (
                                <option key={z.value} value={z.value}>{z.label}</option>
                            ))
                        }
                    </select>
                </div>

                <button type="submit" className="btn btn-primary ">Submit</button>
            </form>
        </div>
        
      </div>
    );
  };

  export default Buy;
