public String serialize(OPMObject opmObject) {
	if (opmObject == null) {
			throw new IllegalArgumentException("OPMObject can not be null!");
	}
	
	ObjectMapper mapper = new ObjectMapper();
	AnnotationIntrospector inspector = new JaxbAnnotationIntrospector(TypeFactory.defaultInstance());
	mapper.setAnnotationIntrospector(inspector);
	
	try {
		return mapper.writeValueAsString(opmObject);
	} catch (JsonProcessingException e) {
		e.printStackTrace();
		return null;
	}
}