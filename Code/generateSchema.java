public String generateSchema(OPMObject opmObject) throws JsonProcessingException,JsonMappingException{
		ObjectMapper m = new ObjectMapper();
		SchemaFactoryWrapper visitor = new SchemaFactoryWrapper();

		m.acceptJsonFormatVisitor(m.constructType(opmObject.getClass()), 
			visitor);
		JsonSchema jsonSchema = visitor.finalSchema();
		
		return m.writerWithDefaultPrettyPrinter().
			writeValueAsString(jsonSchema);
}