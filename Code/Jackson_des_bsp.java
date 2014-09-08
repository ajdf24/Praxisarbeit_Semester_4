public <T extends OPMObject> T deserialize(String string) {
		if (string == null) {
			throw new IllegalArgumentException("String can not be null!");
		}
		if (string.isEmpty()) {
			throw new IllegalArgumentException("String can not be empty!");
		}

		ObjectMapper mapper = new ObjectMapper();
		AnnotationIntrospector inspector = new JaxbAnnotationIntrospector(TypeFactory.defaultInstance());
		mapper.setAnnotationIntrospector(inspector);
		try {
			return (T) (mapper.readValue(string, TestData.class)));
		} catch (IOException | ClassNotFoundException | ClassCastException e) {
			e.printStackTrace();
		}
		return null;
}