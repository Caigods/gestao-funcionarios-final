function FuncionarioTable({ funcionarios }) {
  if (funcionarios.length === 0) {
    return <p>Nenhum funcionário cadastrado.</p>;
  }

  return (
    <div style={styles.container}>
      <h3 style={styles.title}>Funcionários</h3>
      <table style={styles.table}>
        <thead>
          <tr>
            <th style={styles.th}>Nome</th>
            <th style={styles.th}>Data de Admissão</th>
            <th style={styles.th}>Salário</th>
            <th style={styles.th}>Status</th>
          </tr>
        </thead>
        <tbody>
          {funcionarios.map((f) => (
            <tr key={f.id}>
              <td style={styles.td}>{f.nomeFuncionario}</td>
              <td style={styles.td}>{f.dataAdimissao}</td>
              <td style={styles.td}>R$ {parseFloat(f.salario).toFixed(2)}</td>
              <td style={styles.td}>
                <span style={f.statusFuncionario === 'ATIVO' ? styles.ativo : styles.inativo}>
                  {f.statusFuncionario}
                </span>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

const styles = {
  container: {
    backgroundColor: '#fff',
    padding: '24px',
    borderRadius: '8px',
    boxShadow: '0 2px 8px rgba(0,0,0,0.1)',
    maxHeight: '400px',
    overflowY: 'auto',
  },
  title: {
    marginBottom: '16px',
    color: '#333',
  },
  table: {
    width: '100%',
    borderCollapse: 'collapse',
  },
  th: {
    textAlign: 'left',
    padding: '10px',
    backgroundColor: '#f0f2f5',
    borderBottom: '2px solid #ddd',
    fontSize: '14px',
  },
  td: {
    padding: '10px',
    borderBottom: '1px solid #eee',
    fontSize: '14px',
  },
  ativo: {
    color: 'green',
    fontWeight: 'bold',
  },
  inativo: {
    color: 'red',
    fontWeight: 'bold',
  },
};

export default FuncionarioTable;
