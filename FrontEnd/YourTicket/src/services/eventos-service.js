import axios from "axios";

const API_URL = "http://localhost:8081/api/yourticket";

const eventos_service = axios.create({
  baseURL: API_URL,
  headers: {
    "Content-Type": "application/json",
  },
});

// Function to login
export const getEvents = async () => {
  try {
    const response = await eventos_service.get("/event/getall");
    return response.data;
  } catch (error) {
    console.error("Error during login:", error.response || error.message);
    throw error;
  }
};

export const getEvent = async (eventId) => {
    try {
      const response = await eventos_service.get("/event/get?eventId=" + eventId);
      return response.data;
    } catch (error) {
      console.error("Error during login:", error.response || error.message);
      throw error;
    }
};

export const getZones = async (eventId) => {
  try {
    const response = await eventos_service.get("/event/getzones?eventId=" + eventId);
    return response.data;
  } catch (error) {
    console.error("Error during login:", error.response || error.message);
    throw error;
  }
};