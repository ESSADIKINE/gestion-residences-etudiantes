import React from 'react';
import { Container, TextField, Button, Typography, Box } from '@mui/material';

const Signup = () => {
    return (
        <Container maxWidth="sm">
            <Box mt={8} p={4} boxShadow={3} borderRadius={2}>
                <Typography variant="h4" align="center" gutterBottom>
                    Inscription
                </Typography>
                <TextField
                    fullWidth
                    label="Nom complet"
                    variant="outlined"
                    margin="normal"
                />
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
                    S'inscrire
                </Button>
                <Typography align="center" variant="body2" style={{ marginTop: '16px' }}>
                    Vous avez déjà un compte ? <a href="/login">Connectez-vous</a>
                </Typography>
            </Box>
        </Container>
    );
};

export default Signup;
