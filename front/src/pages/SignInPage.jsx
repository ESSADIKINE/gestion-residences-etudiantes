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

const SignInPage = () => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [isLoading, setIsLoading] = useState(false);

  const handleLogin = async (e) => {
    e.preventDefault();
    try {
        const response = await fetch('http://localhost:8080/api/auth/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            credentials: 'include', // Include cookies for session
            body: JSON.stringify({ email, password }), // Ensure payload is correct
        });

        if (response.ok) {
            const data = await response.json();
            alert(data.message || 'Login successful!');
        } else if (response.status === 401) {
            alert('Invalid credentials. Please check your email and password.');
        } else {
            alert('An error occurred during login.');
        }
    } catch (error) {
        console.error('Error during login:', error);
        alert('An unexpected error occurred. Please try again.');
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
            Sign In
          </Typography>
          <Box component="form" onSubmit={handleLogin} noValidate sx={{ width: "100%", mt: 1 }}>
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
            <Button
              type="submit"
              fullWidth
              variant="contained"
              sx={{ mt: 3, mb: 2 }}
              disabled={isLoading}
            >
              {isLoading ? <CircularProgress size={24} /> : "Sign In"}
            </Button>
          </Box>
        </Box>
      </Grid>
    </Grid>
  );
};

export default SignInPage;
