import axios from "axios";

const API_URL = "http://localhost:8081/api/yourticket";

const order_service = axios.create({
  baseURL: API_URL,
  headers: {
    "Content-Type": "application/json"
  },
});

export const getOrders = async (userID) => {
    order_service.defaults.headers.common['Authorization'] = `${JSON.parse(localStorage.getItem("userData")).token}`;
    try {
        const response = await order_service.get("/order/getall?userId="+userID);
        return response.data;
    } catch (error) {
        console.error("Error during login:", error.response || error.message);
        throw error;
    }
};

export const createOrder = async (userID, seatID, paymentMethod) => {
    order_service.defaults.headers.post['Authorization'] = `${JSON.parse(localStorage.getItem("userData")).token}`;
  try {
    const response = await order_service.post("/order/create", {
        userID,
        seatID,
        paymentMethod
    });
    return response;
  } catch (error) {
    console.error("Error during login:", error.response || error.message);
    throw error;
  }
};

export const updateOrder = async (orderID, userName) => {
  order_service.defaults.headers.common['Authorization'] = `${JSON.parse(localStorage.getItem("userData")).token}`;
try {
  const response = await order_service.put("/order/updatewithusername", {
      orderID,
      userName
  });
  return response;
} catch (error) {
  console.error("Error during login:", error.response || error.message);
  throw error;
}
};