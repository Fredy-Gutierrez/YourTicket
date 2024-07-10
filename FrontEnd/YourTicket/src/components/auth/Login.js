import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { login } from "../../services/apiService";

const Login = ({ onLoginSuccess }) => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");
  const [usernameError, setUsernameError] = useState("");
  const [passwordError, setPasswordError] = useState("");
  const [showPassword, setShowPassword] = useState(false);
  // const [validationMessage, setValidationMessage] = useState("");

  const navigate = useNavigate();

  const handleSubmit = async (event) => {
    event.preventDefault();

    // Validaciones adicionales
    let valid = true;
    if (username.length < 4) {
      setUsernameError("El nombre de usuario debe tener al menos 4 caracteres.");
      valid = false;
    } else {
      setUsernameError("");
    }

    if (password.length < 6) {
      setPasswordError("La contraseña debe tener al menos 6 caracteres.");
      valid = false;
    } else {
      setPasswordError("");
    }

    if (!valid) {
      return;
    }

    try {
      const loginData = await login(username, password);
      //console.log("Login response data:", loginData);

      // Simular la validación del token
      if (loginData.token) {
        // setValidationMessage("Token de acceso válido.");
        onLoginSuccess(loginData);
        navigate("/ordenes");
      } else {
        // setValidationMessage("Token de acceso inválido.");
        setError("Nombre de usuario o contraseña incorrectos.");
      }
    } catch (error) {
      console.error("Error during login:", error);
      setError("Nombre de usuario o contraseña incorrectos.");
      // setValidationMessage("Token de acceso inválido.");
    }
  };

  const toggleShowPassword = () => {
    setShowPassword(!showPassword);
  };

  return (
    <div
      className="d-flex justify-content-center align-items-center"
      style={{ minHeight: "80vh" }}
    >
      <div
        className="card shadow-lg p-4"
        style={{ maxWidth: "500px", borderRadius: "15px" }}
      >
        <h2 className="card-title text-center mb-4 text-primary">
          Iniciar Sesión
        </h2>
        {error && <div className="alert alert-danger">{error}</div>}
        {/* {validationMessage && (
          <div className={`alert ${validationMessage.includes("válido") ? "alert-success" : "alert-danger"}`}>
            {validationMessage}
          </div>
        )} */}
        <form onSubmit={handleSubmit}>
          <div className="mb-3">
            <label htmlFor="username" className="form-label text-secondary">
              <i className="fa fa-user me-2" style={{ color: "#000" }}></i>
              Nombre de usuario
            </label>
            <input
              type="text"
              className={`form-control ${usernameError ? "is-invalid" : ""}`}
              id="username"
              value={username}
              onChange={(e) => setUsername(e.target.value)}
              required
            />
            {usernameError && (
              <div className="invalid-feedback">{usernameError}</div>
            )}
          </div>
          <div className="mb-3">
            <label htmlFor="password" className="form-label text-secondary">
              <i className="fa fa-lock me-2" style={{ color: "#000" }}></i>
              Contraseña
            </label>
            <div className="input-group">
              <input
                type={showPassword ? "text" : "password"}
                className={`form-control ${passwordError ? "is-invalid" : ""}`}
                id="password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                required
              />
              <span
                className="input-group-text"
                onClick={toggleShowPassword}
                style={{ cursor: "pointer", backgroundColor: "white" }}
              >
                <i
                  className={`fa ${showPassword ? "fa-eye-slash" : "fa-eye"}`}
                  style={{ color: "#000" }}
                ></i>
              </span>
              {passwordError && (
                <div className="invalid-feedback d-block">{passwordError}</div>
              )}
            </div>
          </div>
          <div className="d-grid">
            <button
              type="submit"
              className="btn btn-primary btn-lg"
              style={{ borderRadius: "50px" }}
            >
              Iniciar Sesión
            </button>
          </div>
        </form>
      </div>
    </div>
  );
};

export default Login;
