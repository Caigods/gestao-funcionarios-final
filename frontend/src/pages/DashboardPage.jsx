import { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import api from '../services/api';
import FuncionarioTable from '../components/FuncionarioTable';
import FuncionarioForm from '../components/FuncionarioForm';

function DashboardPage() {
  const [funcionarios, setFuncionarios] = useState([]);
  const navigate = useNavigate();

  const carregarFuncionarios = async () => {
    try {
      const response = await api.get('/funcionarios');
      setFuncionarios(response.data);
    } catch (error) {
      console.error('Erro ao carregar funcionários', error);
    }
  };

  useEffect(() => {
    carregarFuncionarios();
  }, []);

  const handleLogout = () => {
    localStorage.removeItem('token');
    navigate('/login');
  };

  return (
    <div style={styles.container}>
      <div style={styles.header}>
        <h2 style={styles.title}>Gestão de Funcionários</h2>
        <button style={styles.logoutButton} onClick={handleLogout}>Sair</button>
      </div>
      <FuncionarioForm onFuncionarioAdicionado={carregarFuncionarios} />
      <FuncionarioTable funcionarios={funcionarios} />
    </div>
  );
}

const styles = {
  container: {
    maxWidth: '900px',
    margin: '40px auto',
    padding: '0 16px',
  },
  header: {
    display: 'flex',
    justifyContent: 'space-between',
    alignItems: 'center',
    marginBottom: '24px',
  },
  title: {
    color: '#333',
  },
  logoutButton: {
    padding: '8px 16px',
    backgroundColor: '#ff4d4f',
    color: '#fff',
    border: 'none',
    borderRadius: '4px',
    cursor: 'pointer',
    fontSize: '14px',
  },
};

export default DashboardPage;
