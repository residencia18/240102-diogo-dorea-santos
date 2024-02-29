INSERT INTO Leilao (descricao, valorminimo, status) VALUES
  ('Leilao de arte', 500.00, true);
  
INSERT INTO Concorrente (nome, cpf) VALUES
  ('João Silva', '123.456.789-00'),
  ('Maria Santos', '987.654.321-00'),
  ('Pedro Oliveira', '111.222.333-44');
  


INSERT INTO Lance (leilao_id, concorrente_id, valor) VALUES
  (1, 1, 100.00),
  (1, 2, 120.00),
  (1, 1, 150.00),
  (1, 3, 200.00);