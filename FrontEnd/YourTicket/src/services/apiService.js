import axios from "axios";

const API_URL = "http://localhost:8081/api/yourticket";

const apiService = axios.create({
  baseURL: API_URL,
  headers: {
    "Content-Type": "application/json",
  },
});

// Function to set the API key in the headers
export const setApiKey = (apiKey) => {
  if (apiKey) {
    apiService.defaults.headers.common["api_key"] = apiKey;
  } else {
    delete apiService.defaults.headers.common["api_key"];
  }
};

// Function to login
export const login = async (userName, userPassword) => {
  try {
    const response = await apiService.post("/usersession/login", {
      userName,
      userPassword,
    });
    return response.data;
  } catch (error) {
    console.error("Error during login:", error.response || error.message);
    throw error;
  }
};

// Function to logout
export const logout = () => {
  setApiKey(null);
};

export default apiService;
