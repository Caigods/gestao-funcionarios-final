import { useState } from 'react';
import api from '../services/api';

function FuncionarioForm({ onFuncionarioAdicionado }) {
  const [form, setForm] = useState({
    nomeFuncionario: '',
    dataAdimissao: '',
    salario: '',
    statusFuncionario: 'ATIVO',
  });
  const [erro, setErro] = useState('');
  const [sucesso, setSucesso] = useState('');

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    setErro('');
    setSucesso('');
    try {
      await api.post('/funcionarios', {
        ...form,
        salario: parseFloat(form.salario),
      });
      setSucesso('Funcionário cadastrado com sucesso!');
      setForm({ nomeFuncionario: '', dataAdimissao: '', salario: '', statusFuncionario: 'ATIVO' });
      onFuncionarioAdicionado();
    } catch (error) {
      setErro(error.response?.data || 'Erro ao cadastrar funcionário.');
    }
  };

  return (
    <div style={styles.container}>
      <h3 style={styles.title}>Cadastrar Funcionário</h3>
      <form onSubmit={handleSubmit}>
        <div style={styles.field}>
          <label>Nome</label>
          <input
            style={styles.input}
            name="nomeFuncionario"
            value={form.nomeFuncionario}
            onChange={handleChange}
            required
          />
        </div>
        <div style={styles.field}>
          <label>Data de Admissão</label>
          <input
            style={styles.input}
            type="date"
            name="dataAdimissao"
            value={form.dataAdimissao}
            onChange={handleChange}
            required
          />
        </div>
        <div style={styles.field}>
          <label>Salário</label>
          <input
            style={styles.input}
            type="number"
            step="0.01"
            name="salario"
            value={form.salario}
            onChange={handleChange}
            required
          />
        </div>
        <div style={styles.field}>
          <label>Status</label>
          <select style={styles.input} name="statusFuncionario" value={form.statusFuncionario} onChange={handleChange}>
            <option value="ATIVO">Ativo</option>
            <option value="INATIVO">Inativo</option>
          </select>
        </div>
        {erro && <p style={styles.erro}>{erro}</p>}
        {sucesso && <p style={styles.sucesso}>{sucesso}</p>}
        <button style={styles.button} type="submit">Cadastrar</button>
      </form>
    </div>
  );
}

const styles = {
  container: {
    backgroundColor: '#fff',
    padding: '24px',
    borderRadius: '8px',
    boxShadow: '0 2px 8px rgba(0,0,0,0.1)',
    marginBottom: '24px',
  },
  title: {
    marginBottom: '16px',
    color: '#333',
  },
  field: {
    marginBottom: '12px',
    display: 'flex',
    flexDirection: 'column',
    gap: '4px',
  },
  input: {
    padding: '8px',
    borderRadius: '4px',
    border: '1px solid #ccc',
    fontSize: '14px',
  },
  button: {
    padding: '10px 24px',
    backgroundColor: '#1890ff',
    color: '#fff',
    border: 'none',
    borderRadius: '4px',
    fontSize: '14px',
    cursor: 'pointer',
    marginTop: '8px',
  },
  erro: { color: 'red', fontSize: '13px' },
  sucesso: { color: 'green', fontSize: '13px' },
};

export default FuncionarioForm;
