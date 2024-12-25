import React, { useState } from "react";
import {
  Box,
  Button,
  CircularProgress,
  FormControl,
  Grid,
  CssBaseline,
  InputLabel,
  OutlinedInput,
  TextField,
  Typography,
} from "@mui/material";

const SignUpPage = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [role, setRole] = useState("");
  const [isLoading, setIsLoading] = useState(false);

  const handleSignUp = async (e) => {
    e.preventDefault();
    setIsLoading(true);

    try {
      const response = await fetch("http://localhost:8080/api/auth/register", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({ email, password, role }),
      });

      const data = await response.json();

      if (response.ok) {
        alert("User registered successfully!");
      } else {
        alert(`Registration failed: ${data.message}`);
      }
    } catch (error) {
      alert("Something went wrong. Please try again.");
    } finally {
      setIsLoading(false);
    }
  };

  return (
    <Grid container component="main" sx={{ height: "100vh" }}>
      <CssBaseline />
      <Grid
        item
        xs={12}
        sm={8}
        md={5}
        sx={{ display: "flex", alignItems: "center", justifyContent: "center" }}
      >
        <Box sx={{ display: "flex", flexDirection: "column", alignItems: "center", p: 4 }}>
          <Typography component="h1" variant="h4" sx={{ mb: 3 }}>
            Register
          </Typography>
          <Box component="form" onSubmit={handleSignUp} noValidate sx={{ width: "100%", mt: 1 }}>
            <TextField
              margin="normal"
              required
              fullWidth
              id="email"
              label="Email Address"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
            />
            <FormControl margin="normal" required fullWidth>
              <InputLabel>Password</InputLabel>
              <OutlinedInput
                type="password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
              />
            </FormControl>
            <TextField
              margin="normal"
              required
              fullWidth
              id="role"
              label="Role (ADMIN/RESIDENT/TECHNICIEN)"
              value={role}
              onChange={(e) => setRole(e.target.value)}
            />
            <Button
              type="submit"
              fullWidth
              variant="contained"
              sx={{ mt: 3, mb: 2 }}
              disabled={isLoading}
            >
              {isLoading ? <CircularProgress size={24} /> : "Register"}
            </Button>
          </Box>
        </Box>
      </Grid>
    </Grid>
  );
};

export default SignUpPage;
