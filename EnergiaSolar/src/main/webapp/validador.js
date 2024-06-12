/**
 * Validacao de formulario
 * @autor Anderson Bottega
 */

function validarcidades() {
	let nomecid = frmCidade.nomecid.value
	let janeiro = frmCidade.janeiro.value
	let fevereiro = frmCidade.fevereiro.value
	let marco = frmCidade.marco.value
	let abril = frmCidade.abril.value
	let maio = frmCidade.maio.value
	let junho = frmCidade.junho.value
	let julho = frmCidade.julho.value
	let agosto = frmCidade.agosto.value
	let setembro = frmCidade.setembro.value
	let outubro = frmCidade.outubro.value
	let novembro = frmCidade.novembro.value
	let dezembro = frmCidade.dezembro.value
	if (nomecid === "") {
		alert('Preencha o campo Nome Cidade')
		frmCidade.nomecid.focus()
		return false
	} else if (janeiro === "") {
		alert('Preencha o campo Janeiro')
		frmCidade.janeiro.focus()
		return false
	} else if (fevereiro === "") {
		alert('Preencha o campo Fevereiro')
		frmCidade.fevereiro.focus()
		return false
	} else if (marco === "") {
		alert('Preencha o campo Março')
		frmCidade.marco.focus()
		return false
	} else if (abril === "") {
		alert('Preencha o campo Abril')
		frmCidade.abril.focus()
		return false
	} else if (maio === "") {
		alert('Preencha o campo Maio')
		frmCidade.maio.focus()
		return false
	} else if (junho === "") {
		alert('Preencha o campo Junho')
		frmCidade.junho.focus()
		return false
	} else if (julho === "") {
		alert('Preencha o campo Julho')
		frmCidade.julho.focus()
		return false
	} else if (agosto === "") {
		alert('Preencha o campo Agosto')
		frmCidade.agosto.focus()
		return false
	} else if (setembro === "") {
		alert('Preencha o campo Setembro')
		frmCidade.setembro.focus()
		return false
	} else if (outubro === "") {
		alert('Preencha o campo Outubro')
		frmCidade.outubro.focus()
		return false
	} else if (novembro === "") {
		alert('Preencha o campo Novembro')
		frmCidade.novembro.focus()
		return false
	} else if (dezembro === "") {
		alert('Preencha o campo Dezembro')
		frmCidade.dezembro.focus()
		return false
	} else {
		document.forms["frmCidade"].submit()
	}
}

function validarprodesp() {
	let nummod = frmProd.nummod.value
	let potmod = frmProd.potmod.value
	let efi = frmProd.efi.value
	if (nummod === "") {
		alert('Preencha o campo Número de módulos')
		frmProd.nummod.focus()
		return false
	} else if (potmod === "") {
		alert('Preencha o campo Potência dos módulos')
		frmProd.potmod.focus()
		return false
	} else if (efi === "") {
		alert('Preencha o campo Eficiência')
		frmProd.efi.focus()
		return false
	} else {
		document.forms["frmProd"].submit()
	}
}

function validarclientes() {
	let cli = frmCliente.cli.value
	let cpf = frmCliente.cpf.value
	let empr = frmCliente.empr.value
	let cnpj = frmCliente.cnpj.value
	let tel1 = frmCliente.tel1.value
	let tel2 = frmCliente.tel2.value
	if (cli === "" && empr === "") {
		alert('Insira o nome do cliente ou o nome da empresa')
		frmCliente.cli.focus()
		return false
	} else if (cpf !== "" && cli === "") {
		alert('Insira o nome do cliente ou remova o CPF')
		frmCliente.cli.focus()
		return false
	} else if (cnpj !== "" && empr === "") {
		alert('Insira o nome da empresa ou remova o CNPJ')
		frmCliente.empr.focus()
		return false
	} else if (tel1 === "" && tel2 === "") {
		alert('Insira pelo menos um número de telefone')
		frmCliente.tel1.focus()
		return false
	} else {
		document.forms["frmCliente"].submit()
	}
}