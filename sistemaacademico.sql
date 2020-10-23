-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 23-Out-2020 às 03:36
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
  `DataNascAluno` varchar(12) DEFAULT NULL,
  `codcurso` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `aluno`
--

INSERT INTO `aluno` (`Matricula`, `nomeAluno`, `DataNascAluno`, `codcurso`) VALUES
(1111, 'Carlos Alberto', '11-10-2000', 6),
(1112, 'Ana Carla', '07-10-1997', 2),
(1113, 'Paula Antonia', '20-05-1989', 4),
(1114, 'Paulo Vitor', '15-03-2000', 59),
(1116, 'Amelia da Silva', '14-04-1996', 43),
(1117, 'Amanda Pontes', '01-02-1998', 56);

-- --------------------------------------------------------

--
-- Estrutura da tabela `alunomedia`
--

CREATE TABLE `alunomedia` (
  `Matricula` int(10) UNSIGNED NOT NULL,
  `codDisc` int(10) UNSIGNED NOT NULL,
  `NP1` float DEFAULT NULL,
  `NP2` float DEFAULT NULL,
  `Faltas` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `alunomedia`
--

INSERT INTO `alunomedia` (`Matricula`, `codDisc`, `NP1`, `NP2`, `Faltas`) VALUES
(1111, 4, 10, 10, 0),
(1111, 7, 7, 8, 2),
(1112, 19, 5, 8, 4),
(1112, 4, 6, 7, 2),
(1113, 19, 8, 9, 1),
(1113, 22, 5, 10, 2),
(1113, 25, 6, 8, 3),
(1114, 15, 9, 7, 3),
(1114, 18, 8, 7, 4),
(1116, 14, 9, 6, 1),
(1116, 17, 6, 8, 2),
(1117, 15, 7, 7, 2),
(1117, 18, 9, 7, 3);

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
(1111, 4),
(1111, 7),
(1112, 19),
(1112, 4),
(1113, 19),
(1113, 22),
(1113, 25),
(1114, 15),
(1114, 18),
(1116, 14),
(1116, 17),
(1117, 15),
(1117, 18);

-- --------------------------------------------------------

--
-- Estrutura da tabela `curso`
--

CREATE TABLE `curso` (
  `codCurso` int(10) UNSIGNED NOT NULL,
  `nomeCurso` varchar(50) DEFAULT NULL,
  `tipoCurso` varchar(50) DEFAULT NULL,
  `cargaHoraria` int(11) DEFAULT NULL,
  `codInstituto` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `curso`
--

INSERT INTO `curso` (`codCurso`, `nomeCurso`, `tipoCurso`, `cargaHoraria`, `codInstituto`) VALUES
(2, 'Engenharia da Computação', 'Curso Superior', 4000, 1),
(3, 'Administração pública', 'Doutorado', 3510, 1),
(4, 'Sistemas da Informação', 'Curso Superior', 3500, 1),
(5, 'Medicina', 'Curso Superior', 5000, 2),
(6, 'Farmacologia', 'Curso Superior', 4000, 2),
(9, 'Odontologia', 'Mestrado', 4000, 3),
(10, 'Recursos Humanos', 'Doutorado', 3500, 3),
(11, 'Administração', 'Mestrado', 4000, 3),
(12, 'Administração pública', 'Bacharel', 4000, 3),
(14, 'Ciência de dados', 'Bacharel', 4000, 3),
(15, 'Ciencia da Computação', 'Bacharel', 4000, 3),
(16, 'Ciência de dados', 'Bacharel', 4000, 3),
(17, 'Ciência de dados', 'Bacharel', 4000, 3),
(18, 'Ciências biológicas', 'Mestrado', 4000, 3),
(19, 'Ciências contábeis', 'Bacharel', 4000, 3),
(20, 'Ciências da computação', 'Bacharel', 4000, 3),
(21, 'Ciências da natureza', 'Bacharel', 4000, 3),
(22, 'Ciências econômicas', 'Bacharel', 4000, 3),
(23, 'Ciências exatas', 'Bacharel', 4000, 3),
(24, 'Ciências humanas', 'Bacharel', 4000, 3),
(25, 'Comércio exterior', 'Bacharel', 4000, 3),
(26, 'Computação', 'Bacharel', 4000, 3),
(27, 'Comunicação institucional', 'Bacharel', 4000, 3),
(29, 'Defesa cibernética', 'Bacharel', 4000, 3),
(30, 'Design de moda', 'Bacharel', 4000, 3),
(31, 'Design gráfico', 'Bacharel', 4000, 3),
(32, 'Direito', 'Bacharel', 4000, 3),
(33, 'Educação física', 'Bacharel', 4000, 3),
(34, 'Enfermagem', 'Bacharel', 4000, 3),
(35, 'Engenharia ambiental e sanitária', 'Bacharel', 4000, 3),
(36, 'Engenharia civil', 'Bacharel', 4000, 3),
(37, 'Engenharia de controle e automação', 'Bacharel', 4000, 3),
(38, 'Engenharia de petróleo', 'Bacharel', 4000, 3),
(39, 'Engenharia de produção', 'Bacharel', 4000, 3),
(40, 'Engenharia de software', 'Bacharel', 4000, 3),
(41, 'Engenharia elétrica', 'Bacharel', 4000, 3),
(42, 'Engenharia mecânica', 'Bacharel', 4000, 3),
(43, 'Estética e cosmética', 'Bacharel', 4000, 3),
(44, 'Farmácia', 'Bacharel', 4000, 3),
(45, 'Filosofia', 'Mestrado', 4000, 3),
(46, 'Física', 'Bacharel', 4000, 3),
(47, 'Fisioterapia', 'Bacharel', 4000, 3),
(48, 'Formacão pedagógica', 'Bacharel', 4000, 3),
(49, 'Gastronomia', 'Bacharel', 4000, 3),
(50, 'Geografia', 'Bacharel', 4000, 3),
(51, 'Gerontologia - bem estar e educação', 'Bacharel', 4000, 3),
(52, 'Gestão ambiental', 'Bacharel', 4000, 3),
(53, 'Gestão comercial', 'Bacharel', 4000, 3),
(54, 'Gestão da produção industrial', 'Bacharel', 4000, 3),
(55, 'Gestão da qualidade', 'Bacharel', 4000, 3),
(56, 'Gestão da tecnologia da informação', 'Bacharel', 4000, 3),
(57, 'Gestão de recursos humanos', 'Bacharel', 4000, 3),
(58, 'Gestão de segurança privada', 'Bacharel', 4000, 3),
(59, 'Gestão de turismo', 'Bacharel', 4000, 3),
(60, 'Gestão e empreendedorismo', 'Bacharel', 4000, 3),
(61, 'Ciencia da Computação', 'Doutorado', 4000, 3),
(62, 'Administração', 'Especialista Lato Sensu', 34553, 345),
(63, 'Biomedicina', 'Mestrado', 5644, 4),
(64, 'Marketing', 'Doutorado', 4666, 4),
(65, 'Arquitetura e urbanismo', 'Bacharel', 34534, 2),
(66, 'Artes visuais', 'Bacharel', 32432, 2),
(67, 'Analise e desenvolvimento de sistemas', 'Bacharel', 345, 3);

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
(2, 3),
(2, 4),
(2, 5),
(2, 6),
(2, 7),
(2, 8),
(2, 9),
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
(4, 27),
(4, 28),
(5, 10),
(5, 13),
(5, 14),
(5, 15),
(5, 16),
(5, 17),
(5, 18),
(6, 10),
(6, 13),
(6, 14),
(6, 15);

-- --------------------------------------------------------

--
-- Estrutura da tabela `disciplina`
--

CREATE TABLE `disciplina` (
  `CodDisc` int(10) UNSIGNED NOT NULL,
  `nomeDisc` varchar(30) DEFAULT NULL,
  `Cargahoraria` int(11) DEFAULT NULL,
  `AulasSemana` int(11) DEFAULT NULL,
  `IdentProf` int(12) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `disciplina`
--

INSERT INTO `disciplina` (`CodDisc`, `nomeDisc`, `Cargahoraria`, `AulasSemana`, `IdentProf`) VALUES
(3, 'calculo3', 80, 4, 9),
(4, 'matematica1', 0, 2, 5),
(5, 'matematica2', 0, 2, 6),
(6, 'matematica3', 40, 2, 6),
(7, 'fisica1', 0, 3, 7),
(8, 'fisica2', 0, 2, 8),
(9, 'fisica3', 0, 2, 9),
(10, 'anatomia1', 80, 4, 10),
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
(27, 'Estrutura de Dados', 40, 2, 3),
(28, 'Estudos das Leis', 80, 4, 4),
(32, 'Juridico2', 40, 2, 9),
(33, 'Juridico3', 40, 2, 4),
(34, 'Normas1', 40, 2, 9),
(35, 'Normas2', 40, 2, 3),
(36, 'Normas3', 40, 2, 5),
(37, 'Filosofia', 0, 2, 14),
(38, 'wf', 44, 4, 6);

-- --------------------------------------------------------

--
-- Estrutura da tabela `professor`
--

CREATE TABLE `professor` (
  `IdentProf` int(12) NOT NULL,
  `NomeProf` varchar(35) NOT NULL,
  `DataNasc` varchar(15) NOT NULL,
  `EspecProf` varchar(35) NOT NULL,
  `TituloProf` varchar(35) NOT NULL,
  `logradouro` varchar(80) DEFAULT NULL,
  `bairro` varchar(50) DEFAULT NULL,
  `cidade` varchar(50) DEFAULT NULL,
  `num` varchar(12) DEFAULT NULL,
  `uf` varchar(35) DEFAULT NULL,
  `telefone` varchar(20) DEFAULT NULL,
  `telRes` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `professor`
--

INSERT INTO `professor` (`IdentProf`, `NomeProf`, `DataNasc`, `EspecProf`, `TituloProf`, `logradouro`, `bairro`, `cidade`, `num`, `uf`, `telefone`, `telRes`) VALUES
(3, 'ANDRÉ LUIS ', '  -  -    ', 'Informática', 'Especialista Lato Sensu', '', '', '', '', '', '', ''),
(4, 'ARNALDO MÁRCIO', '  -  -    ', 'Odontologia', 'Especialista Lato Sensu', '', '', '', '', '', '', ''),
(5, 'ELISSON ANTÔNIO', '  -  -    ', 'Medicina', 'Especialista Lato Sensu', '', '', '', '', '', '', ''),
(6, 'FERNANDO SEGATO', '  -  -    ', 'Odontologia', 'Especialista Lato Sensu', '', '', '', '', '', '', ''),
(7, 'FLÁVIO TEIXEIRA', '  -  -    ', 'Informática', 'Bacharel', '', '', '', '', '', '', ''),
(8, 'INÊS CONCEIÇÃO', '  -  -    ', 'Psicologia', 'Especialista Lato Sensu', '', '', '', '', '', '', ''),
(9, 'JOÃO BATISTA ', '01-03-1990', 'Direito', 'Especialista Lato Sensu', '', '', '', '', '', '', ''),
(10, 'JÚLIO CÉSAR', '  -  -    ', 'Informática', 'Bacharel', '', '', '', '', '', '', ''),
(14, 'William', '19-01-1997', 'Matemática', 'Bacharel', 'Rua Michel', 'Heliopolis', 'São Paulo ', '34', 'MG', '(32) 93542-5245', '(11) 4494-5435');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `aluno`
--
ALTER TABLE `aluno`
  ADD PRIMARY KEY (`Matricula`),
  ADD KEY `aluno_codCurso_fk` (`codcurso`);

--
-- Índices para tabela `alunomedia`
--
ALTER TABLE `alunomedia`
  ADD KEY `alunomedia_media_fk` (`Matricula`),
  ADD KEY `alunomedia_codDisc_fk` (`codDisc`);

--
-- Índices para tabela `aluno_disc`
--
ALTER TABLE `aluno_disc`
  ADD KEY `alunoDisc_matricula_fk` (`Matricula`),
  ADD KEY `alunoDisc_codDisc_fk` (`codDisc`);

--
-- Índices para tabela `curso`
--
ALTER TABLE `curso`
  ADD PRIMARY KEY (`codCurso`);

--
-- Índices para tabela `cursodisc`
--
ALTER TABLE `cursodisc`
  ADD KEY `cursoDisc_codCurso_fk` (`codCurso`),
  ADD KEY `cursoDisc_codDisc_fk` (`codDisc`);

--
-- Índices para tabela `disciplina`
--
ALTER TABLE `disciplina`
  ADD PRIMARY KEY (`CodDisc`),
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
-- AUTO_INCREMENT de tabela `aluno`
--
ALTER TABLE `aluno`
  MODIFY `Matricula` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1137;

--
-- AUTO_INCREMENT de tabela `curso`
--
ALTER TABLE `curso`
  MODIFY `codCurso` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=70;

--
-- AUTO_INCREMENT de tabela `disciplina`
--
ALTER TABLE `disciplina`
  MODIFY `CodDisc` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;

--
-- AUTO_INCREMENT de tabela `professor`
--
ALTER TABLE `professor`
  MODIFY `IdentProf` int(12) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `aluno`
--
ALTER TABLE `aluno`
  ADD CONSTRAINT `aluno_codCurso_fk` FOREIGN KEY (`codcurso`) REFERENCES `curso` (`codCurso`) ON UPDATE CASCADE;

--
-- Limitadores para a tabela `alunomedia`
--
ALTER TABLE `alunomedia`
  ADD CONSTRAINT `alunomedia_codDisc_fk` FOREIGN KEY (`codDisc`) REFERENCES `disciplina` (`CodDisc`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `alunomedia_media_fk` FOREIGN KEY (`Matricula`) REFERENCES `aluno` (`Matricula`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `aluno_disc`
--
ALTER TABLE `aluno_disc`
  ADD CONSTRAINT `alunoDisc_codDisc_fk` FOREIGN KEY (`codDisc`) REFERENCES `disciplina` (`CodDisc`) ON UPDATE NO ACTION,
  ADD CONSTRAINT `alunoDisc_matricula_fk` FOREIGN KEY (`Matricula`) REFERENCES `aluno` (`Matricula`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `cursodisc`
--
ALTER TABLE `cursodisc`
  ADD CONSTRAINT `cursoDisc_codCurso_fk` FOREIGN KEY (`codCurso`) REFERENCES `curso` (`codCurso`) ON UPDATE CASCADE,
  ADD CONSTRAINT `cursoDisc_codDisc_fk` FOREIGN KEY (`codDisc`) REFERENCES `disciplina` (`CodDisc`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limitadores para a tabela `disciplina`
--
ALTER TABLE `disciplina`
  ADD CONSTRAINT `disciplina_IdentProf_fk` FOREIGN KEY (`IdentProf`) REFERENCES `professor` (`IdentProf`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
