import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import { ThemeProvider, createTheme, CssBaseline } from '@mui/material';
import SignInPage from './pages/SignInPage';
import HomePage from './pages/HomePage';
import SignUpPage from './pages/SignUpPage';

// Define your custom theme
const theme = createTheme({
  palette: {
    mode: 'light', // Switch between 'light' or 'dark'
    primary: {
      main: '#1976d2', // Primary color
    },
    secondary: {
      main: '#f50057', // Secondary color
    },
    background: {
      default: '#f4f6f8', // Default background color
      paper: '#ffffff', // Background color for paper-like components
    },
    text: {
      primary: '#333333', // Primary text color
      secondary: '#757575', // Secondary text color
    },
  },
  typography: {
    fontFamily: 'Roboto, Arial, sans-serif', // Font family
    h1: {
      fontSize: '2.5rem',
      fontWeight: 600,
    },
    h2: {
      fontSize: '2rem',
      fontWeight: 500,
    },
    body1: {
      fontSize: '1rem',
      lineHeight: 1.5,
    },
    button: {
      textTransform: 'none', // Prevent uppercase transformation of buttons
    },
  },
});

function App() {
  return (
    <ThemeProvider theme={theme}>
      <CssBaseline /> {/* Normalize styles across browsers */}
      <Router>
        <Routes>
        <Route path="/" element={<HomePage />} />
        <Route path="/register" element={<SignUpPage />} />
        <Route path="/login" element={<SignInPage />} />
        </Routes>
      </Router>
    </ThemeProvider>
  );
}

export default App;
