import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import api from '../services/api';

function LoginPage() {
  const [email, setEmail] = useState('');
  const [senha, setSenha] = useState('');
  const [erro, setErro] = useState('');
  const navigate = useNavigate();

  const handleLogin = async (e) => {
    e.preventDefault();
    setErro('');
    try {
      const response = await api.post('/usuarios/login', { email, senha });
      localStorage.setItem('token', response.data.token);
      navigate('/dashboard');
    } catch (error) {
      setErro('E-mail ou senha inválidos.');
    }
  };

  return (
    <div style={styles.container}>
      <div style={styles.card}>
        <h2 style={styles.title}>Login</h2>
        <form onSubmit={handleLogin}>
          <div style={styles.field}>
            <label>E-mail</label>
            <input
              style={styles.input}
              type="email"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              required
            />
          </div>
          <div style={styles.field}>
            <label>Senha</label>
            <input
              style={styles.input}
              type="password"
              value={senha}
              onChange={(e) => setSenha(e.target.value)}
              required
            />
          </div>
          {erro && <p style={styles.erro}>{erro}</p>}
          <button style={styles.button} type="submit">Entrar</button>
        </form>
      </div>
    </div>
  );
}

const styles = {
  container: {
    display: 'flex',
    justifyContent: 'center',
    alignItems: 'center',
    height: '100vh',
    backgroundColor: '#f0f2f5',
  },
  card: {
    backgroundColor: '#fff',
    padding: '40px',
    borderRadius: '8px',
    boxShadow: '0 2px 8px rgba(0,0,0,0.1)',
    width: '350px',
  },
  title: {
    textAlign: 'center',
    marginBottom: '24px',
    color: '#333',
  },
  field: {
    marginBottom: '16px',
    display: 'flex',
    flexDirection: 'column',
    gap: '6px',
  },
  input: {
    padding: '10px',
    borderRadius: '4px',
    border: '1px solid #ccc',
    fontSize: '14px',
  },
  button: {
    width: '100%',
    padding: '12px',
    backgroundColor: '#1890ff',
    color: '#fff',
    border: 'none',
    borderRadius: '4px',
    fontSize: '16px',
    cursor: 'pointer',
    marginTop: '8px',
  },
  erro: {
    color: 'red',
    fontSize: '13px',
    marginBottom: '8px',
  },
};

export default LoginPage;
