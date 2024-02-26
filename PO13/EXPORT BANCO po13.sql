-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 26/02/2024 às 03:18
-- Versão do servidor: 10.4.32-MariaDB
-- Versão do PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `po13`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `aeroporto`
--

CREATE TABLE `aeroporto` (
  `id` int(11) NOT NULL,
  `icao` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `aeroporto`
--

INSERT INTO `aeroporto` (`id`, `icao`, `nome`) VALUES
(1, 'ICAO1', 'Aeroporto1');

-- --------------------------------------------------------

--
-- Estrutura para tabela `modeloaeronave`
--

CREATE TABLE `modeloaeronave` (
  `id` int(11) NOT NULL,
  `fabricante` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `modeloaeronave`
--

INSERT INTO `modeloaeronave` (`id`, `fabricante`, `nome`) VALUES
(1, 'FAbricante 1', 'Modelo Aeronave 1');

-- --------------------------------------------------------

--
-- Estrutura para tabela `piloto`
--

CREATE TABLE `piloto` (
  `id` int(11) NOT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `numbreve` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `piloto`
--

INSERT INTO `piloto` (`id`, `nome`, `numbreve`) VALUES
(1, 'Piloto 1', NULL),
(2, 'Piloto 1', 'Num Breve 1');

-- --------------------------------------------------------

--
-- Estrutura para tabela `usuario`
--

CREATE TABLE `usuario` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `usuario`
--

INSERT INTO `usuario` (`id`, `email`, `nome`, `senha`) VALUES
(1, 'diogodorea@gmail.com', 'Diogo3', '123');

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `aeroporto`
--
ALTER TABLE `aeroporto`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `modeloaeronave`
--
ALTER TABLE `modeloaeronave`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `piloto`
--
ALTER TABLE `piloto`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `aeroporto`
--
ALTER TABLE `aeroporto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `modeloaeronave`
--
ALTER TABLE `modeloaeronave`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `piloto`
--
ALTER TABLE `piloto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
