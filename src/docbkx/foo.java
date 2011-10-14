public void testInclude() throws Exception
      {
        _contextHandler.addServlet(IncludeServlet.class, "/IncludeServlet/*");
        _contextHandler.addServlet(AssertIncludeServlet.class, "/AssertIncludeServlet/*");

        String expected=
            "HTTP/1.1 200 OK\r\n"+
            "Content-Length: 0\r\n"+
            "\r\n";

        String responses = _connector.getResponses("GET /context/IncludeServlet?do=assertinclude&do=more&test=1 HTTP/1.1\n" + "Host: localhost\n\n");

        assertEquals(expected, responses);
      }