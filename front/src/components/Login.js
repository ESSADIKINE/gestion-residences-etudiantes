import React from 'react';
import { Container, TextField, Button, Typography, Box } from '@mui/material';

const Login = () => {
    return (
        <Container maxWidth="sm">
            <Box mt={8} p={4} boxShadow={3} borderRadius={2}>
                <Typography variant="h4" align="center" gutterBottom>
                    Connexion
                </Typography>
                <TextField
                    fullWidth
                    label="Email"
                    variant="outlined"
                    margin="normal"
                />
                <TextField
                    fullWidth
                    label="Mot de passe"
                    type="password"
                    variant="outlined"
                    margin="normal"
                />
                <Button
                    variant="contained"
                    color="primary"
                    fullWidth
                    style={{ marginTop: '16px' }}
                >
                    Se connecter
                </Button>
                <Typography align="center" variant="body2" style={{ marginTop: '16px' }}>
                    Vous n'avez pas de compte ? <a href="/signup">Inscrivez-vous</a>
                </Typography>
            </Box>
        </Container>
    );
};

export default Login;
