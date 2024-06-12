/**
 * Confirmação de Exclusão
 * @autor Anderson Bottega
 */
 
 function confirmarcidade(){
	let resposta = confirm("Confirma a exclusão desta cidade?")
	if(resposta === true){
		document.forms["frmExclude"].submit()
		//window.location.href = "delete?idcid=" + idcid
	}
}

 function confirmarcliente(){
	let resposta = confirm("Confirma a exclusão deste cliente?")
	if(resposta === true){
		document.forms["frmExcludecli"].submit()
	}
}