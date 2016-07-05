function select(docName, fieldId) {
	$( "#" + fieldId ).load( "app/html/" + docName );
}