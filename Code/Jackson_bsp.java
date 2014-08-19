ObjectMapper mapper = new ObjectMapper();
AnnotationIntrospector inspector = new JaxbAnnotationIntrospector(TypeFactory.defaultInstance());
mapper.setAnnotationIntrospector(inspector);

if (opmObject == null) {
			throw new IllegalArgumentException("OPMObject can not be null!");
		}
try {
	return mapper.writeValueAsString(opmObject);
} catch (JsonProcessingException e) {
	e.printStackTrace();
	return null;
}