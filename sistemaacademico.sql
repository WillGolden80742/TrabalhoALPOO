-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 20-Out-2020 às 00:27
-- Versão do servidor: 10.4.11-MariaDB
-- versão do PHP: 7.4.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `sistemaacademico`
--

DELIMITER $$
--
-- Funções
--
CREATE DEFINER=`root`@`localhost` FUNCTION `AlunoDisc` (`cod` INT(10)) RETURNS INT(10) BEGIN
DECLARE contagem int(10) DEFAULT 0;
SELECT COUNT(aluno.Matricula) into contagem FROM aluno
join aluno_disc
on aluno.Matricula = aluno_disc.Matricula
WHERE aluno.Matricula LIKE cod;
RETURN contagem;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `aluno`
--

CREATE TABLE `aluno` (
  `Matricula` int(10) UNSIGNED NOT NULL,
  `nomeAluno` varchar(35) DEFAULT NULL,
  `DataNascAluno` date DEFAULT NULL,
  `codcurso` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `aluno`
--

INSERT INTO `aluno` (`Matricula`, `nomeAluno`, `DataNascAluno`, `codcurso`) VALUES
(1111, 'Carlos Alberto', '2000-10-29', 1),
(1112, 'Ana Carla', '1997-07-10', 2),
(1113, 'Paula Antonia', '1989-05-20', 4),
(1114, 'Paulo Vitor', '2000-03-15', 5),
(1116, 'Amelia da Silva', '1996-04-14', 6),
(1117, 'Amanda Pontes', '1998-02-01', 5),
(1118, 'Felipe Morales', '1980-10-30', 8),
(1119, 'Lucas Gabriel', '1996-03-10', 4),
(1120, 'Paola Oliveira', '1987-11-11', 2),
(1121, 'Rafael Miralha', '2001-02-01', 3),
(1122, 'Jose Ygor', '2001-03-10', 4),
(1123, 'Antonio Carlos', '1984-09-30', 1),
(1124, 'Aparecido da Silva', '1994-01-05', 6),
(1125, 'Patricia Amaral', '1996-08-25', 7),
(1126, 'Paloma Quino', '2002-12-25', 8),
(1127, 'Maria Gabriela', '1993-10-29', 9),
(1128, 'Manuele Pereira', '1999-09-09', 7),
(1129, 'Felipe Gonçalves', '1995-05-05', 10),
(1130, 'Vitoria Silva', '1996-07-17', 9),
(1131, 'Bruna Isabelly', '2000-02-02', 10);

-- --------------------------------------------------------

--
-- Estrutura da tabela `alunomedia`
--

CREATE TABLE `alunomedia` (
  `Matricula` int(10) UNSIGNED NOT NULL,
  `codDisc` int(10) UNSIGNED NOT NULL,
  `NP1` int(11) DEFAULT NULL,
  `NP2` int(11) DEFAULT NULL,
  `Faltas` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `alunomedia`
--

INSERT INTO `alunomedia` (`Matricula`, `codDisc`, `NP1`, `NP2`, `Faltas`) VALUES
(1111, 1, 10, 10, 0),
(1111, 4, 10, 10, 0),
(1111, 7, 7, 8, 2),
(1112, 19, 5, 8, 4),
(1112, 1, 5, 5, 3),
(1112, 4, 6, 7, 2),
(1113, 19, 8, 9, 1),
(1113, 22, 5, 10, 2),
(1113, 25, 6, 8, 3),
(1114, 12, 10, 6, 2),
(1114, 15, 9, 7, 3),
(1114, 18, 8, 7, 4),
(1116, 11, 8, 6, 1),
(1116, 14, 9, 6, 1),
(1116, 17, 6, 8, 2),
(1117, 12, 5, 10, 4),
(1117, 15, 7, 7, 2),
(1117, 18, 9, 7, 3),
(1118, 29, 10, 6, 1),
(1118, 32, 8, 7, 1),
(1118, 35, 9, 8, 2),
(1119, 20, 8, 8, 2),
(1119, 23, 9, 7, 2),
(1119, 26, 6, 8, 1),
(1120, 2, 5, 9, 3),
(1120, 5, 6, 8, 2),
(1120, 8, 4, 9, 4),
(1121, 3, 10, 10, 0),
(1121, 6, 10, 10, 0),
(1121, 9, 10, 10, 0),
(1122, 3, 10, 5, 3),
(1122, 6, 7, 8, 5),
(1122, 9, 4, 8, 1),
(1123, 1, 5, 7, 3),
(1123, 4, 7, 3, 2),
(1123, 7, 8, 10, 3),
(1124, 11, 7, 5, 1),
(1124, 14, 3, 10, 5),
(1124, 17, 4, 7, 3),
(1125, 10, 6, 7, 0),
(1125, 13, 7, 5, 1),
(1125, 16, 4, 9, 3),
(1126, 28, 10, 8, 2),
(1126, 31, 8, 9, 1),
(1126, 34, 9, 7, 4),
(1127, 13, 10, 6, 3),
(1127, 16, 8, 7, 2),
(1127, 34, 10, 8, 2),
(1128, 11, 8, 9, 3),
(1128, 14, 10, 5, 6),
(1128, 17, 6, 8, 1),
(1129, 15, 8, 5, 2),
(1129, 29, 7, 7, 1),
(1129, 35, 6, 8, 3),
(1130, 13, 7, 9, 2),
(1130, 16, 3, 8, 1),
(1130, 36, 6, 8, 2),
(1131, 13, 10, 10, 3),
(1131, 28, 9, 8, 2),
(1131, 34, 8, 7, 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `aluno_disc`
--

CREATE TABLE `aluno_disc` (
  `Matricula` int(10) UNSIGNED NOT NULL,
  `codDisc` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `aluno_disc`
--

INSERT INTO `aluno_disc` (`Matricula`, `codDisc`) VALUES
(1111, 1),
(1111, 4),
(1111, 7),
(1112, 19),
(1112, 1),
(1112, 4),
(1113, 19),
(1113, 22),
(1113, 25),
(1114, 12),
(1114, 15),
(1114, 18),
(1116, 11),
(1116, 14),
(1116, 17),
(1117, 12),
(1117, 15),
(1117, 18),
(1118, 29),
(1118, 32),
(1118, 35),
(1119, 20),
(1119, 23),
(1119, 26),
(1120, 2),
(1120, 5),
(1120, 8),
(1121, 3),
(1121, 6),
(1121, 9),
(1122, 3),
(1122, 6),
(1122, 9),
(1123, 1),
(1123, 4),
(1123, 7),
(1124, 11),
(1124, 14),
(1124, 17),
(1125, 10),
(1125, 13),
(1125, 16),
(1126, 28),
(1126, 31),
(1126, 34),
(1127, 13),
(1127, 16),
(1127, 34),
(1128, 11),
(1128, 14),
(1128, 17),
(1129, 15),
(1129, 29),
(1129, 35),
(1130, 13),
(1130, 16),
(1130, 36),
(1131, 13),
(1131, 28),
(1131, 34);

-- --------------------------------------------------------

--
-- Estrutura da tabela `curso`
--

CREATE TABLE `curso` (
  `codCurso` int(10) UNSIGNED NOT NULL,
  `nomeCurso` varchar(35) DEFAULT NULL,
  `tipoCurso` varchar(20) DEFAULT NULL,
  `cargaHoraria` int(11) DEFAULT NULL,
  `codInstituto` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `curso`
--

INSERT INTO `curso` (`codCurso`, `nomeCurso`, `tipoCurso`, `cargaHoraria`, `codInstituto`) VALUES
(1, 'Engenharia Eletrica', 'Curso Superior', 4400, 1),
(2, 'Engenharia da Computação', 'Curso Superior', 4000, 1),
(3, 'Ciencia da Computação', 'Curso Superior', 3500, 1),
(4, 'Sistemas da Informação', 'Curso Superior', 3500, 1),
(5, 'Medicina', 'Curso Superior', 5000, 2),
(6, 'Farmacologia', 'Curso Superior', 4000, 2),
(7, 'Odontologia', 'Curso Superior', 4500, 2),
(8, 'Direito', 'Curso Superior', 5000, 3),
(9, 'Psicologia', 'Curso Superior', 4000, 3),
(10, 'Recursos Humanos', 'Curso Superior', 3500, 3);

-- --------------------------------------------------------

--
-- Estrutura da tabela `cursodisc`
--

CREATE TABLE `cursodisc` (
  `codCurso` int(10) UNSIGNED NOT NULL,
  `codDisc` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `cursodisc`
--

INSERT INTO `cursodisc` (`codCurso`, `codDisc`) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5),
(1, 6),
(1, 7),
(1, 8),
(1, 9),
(2, 1),
(2, 2),
(2, 3),
(2, 4),
(2, 5),
(2, 6),
(2, 7),
(2, 8),
(2, 9),
(3, 1),
(3, 2),
(3, 3),
(3, 4),
(3, 5),
(3, 6),
(3, 7),
(3, 8),
(3, 9),
(4, 19),
(4, 20),
(4, 21),
(4, 22),
(4, 24),
(4, 25),
(4, 26),
(4, 27),
(4, 28),
(5, 10),
(5, 11),
(5, 12),
(5, 13),
(5, 14),
(5, 15),
(5, 16),
(5, 17),
(5, 18),
(6, 10),
(6, 11),
(6, 12),
(6, 13),
(6, 14),
(6, 15),
(6, 16),
(6, 17),
(6, 18),
(7, 10),
(7, 11),
(7, 12),
(7, 13),
(7, 14),
(7, 15),
(7, 16),
(7, 17),
(7, 18),
(8, 28),
(8, 29),
(8, 30),
(8, 31),
(8, 32),
(8, 33),
(8, 34),
(8, 35),
(8, 36),
(9, 13),
(9, 14),
(9, 15),
(9, 16),
(9, 17),
(9, 18),
(9, 34),
(9, 35),
(9, 36),
(10, 13),
(10, 14),
(10, 15),
(10, 28),
(10, 29),
(10, 30),
(10, 34),
(10, 35),
(10, 36);

-- --------------------------------------------------------

--
-- Estrutura da tabela `disciplina`
--

CREATE TABLE `disciplina` (
  `CodDisc` int(10) UNSIGNED NOT NULL,
  `nomeDisc` varchar(30) DEFAULT NULL,
  `Cargahoraria` int(11) DEFAULT NULL,
  `AulasSemana` int(11) DEFAULT NULL,
  `IdentProf` int(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `disciplina`
--

INSERT INTO `disciplina` (`CodDisc`, `nomeDisc`, `Cargahoraria`, `AulasSemana`, `IdentProf`) VALUES
(1, 'Calculo1', 80, 4, 1),
(2, 'Calculo2', 80, 4, 2),
(3, 'calculo3', 80, 4, 3),
(4, 'matematica1', 40, 2, 5),
(5, 'matematica2', 40, 2, 6),
(6, 'matematica3', 40, 2, 6),
(7, 'fisica1', 40, 2, 7),
(8, 'fisica2', 40, 2, 8),
(9, 'fisica3', 40, 2, 9),
(10, 'anatomia1', 80, 4, 10),
(11, 'anatomia2', 80, 4, 1),
(12, 'anatomia3', 80, 4, 2),
(13, 'saude1', 40, 2, 3),
(14, 'saude2', 40, 2, 5),
(15, 'saude3', 40, 2, 4),
(16, 'biologia1', 40, 2, 4),
(17, 'biologia2', 40, 2, 5),
(18, 'biologia3', 40, 2, 6),
(19, 'computação1', 80, 4, 7),
(20, 'computação2', 80, 4, 8),
(21, 'computação3', 80, 4, 9),
(22, 'Programação1', 40, 2, 7),
(23, 'Programação2', 40, 2, 3),
(24, 'Programação3', 40, 2, 9),
(25, 'Estrutura de Dados', 40, 2, 4),
(26, 'Estrutura de Dados', 40, 2, 1),
(27, 'Estrutura de Dados', 40, 2, 3),
(28, 'Estudos das Leis', 80, 4, 4),
(29, 'Estudos das Leis', 80, 4, 2),
(30, 'Estudos das Leis', 80, 4, 1),
(31, 'Juridico1', 40, 2, 2),
(32, 'Juridico2', 40, 2, 9),
(33, 'Juridico3', 40, 2, 4),
(34, 'Normas1', 40, 2, 9),
(35, 'Normas2', 40, 2, 3),
(36, 'Normas3', 40, 2, 5);

-- --------------------------------------------------------

--
-- Estrutura da tabela `professor`
--

CREATE TABLE `professor` (
  `IdentProf` int(12) NOT NULL,
  `NomeProf` varchar(35) NOT NULL,
  `DataNasc` varchar(15) NOT NULL,
  `EspecProf` varchar(35) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `professor`
--

INSERT INTO `professor` (`IdentProf`, `NomeProf`, `DataNasc`, `EspecProf`) VALUES
(1, 'ADRIANE MARIA', '', ''),
(2, 'ALEXANDRE ELISE', '', ''),
(3, 'ANDRÉ LUIS ', '', ''),
(4, 'ARNALDO MÁRCIO', '', ''),
(5, 'ELISSON ANTÔNIO', '', ''),
(6, 'FERNANDO SEGATO', '', ''),
(7, 'FLÁVIO TEIXEIRA', '', ''),
(8, 'INÊS CONCEIÇÃO', '', ''),
(9, 'JOÃO BATISTA ', '', ''),
(10, 'JÚLIO CÉSAR', '', '');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `disciplina`
--
ALTER TABLE `disciplina`
  ADD KEY `disciplina_IdentProf_fk` (`IdentProf`);

--
-- Índices para tabela `professor`
--
ALTER TABLE `professor`
  ADD PRIMARY KEY (`IdentProf`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `professor`
--
ALTER TABLE `professor`
  MODIFY `IdentProf` int(12) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `disciplina`
--
ALTER TABLE `disciplina`
  ADD CONSTRAINT `disciplina_IdentProf_fk` FOREIGN KEY (`IdentProf`) REFERENCES `professor` (`IdentProf`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
