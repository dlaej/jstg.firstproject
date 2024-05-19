홈페이지 소개 페이지 (프론트엔드/백엔드)
- SpringMVC의 ModelAndView를 이용한 소개 페이지 렌더링 기능

```java
@GetMapping("/about.do")
	public ModelAndView about() throws Exception {
		ModelAndView mv = new ModelAndView("/first/about");		
		
		return mv;
	}

```
/about.do 라는 주소로 get메서드 요청이 들어왔을 때 실행되는 컨트롤러 메서드이다.
위 요청이 들어왔을 때 실행되는 메서드는 about()메서드이다.
이 메서드의 반환 값은 ModelAndView 클래스 형태이다.
ModelAndView 클래스는 Spring 프레임워크의 mvc패턴에서 자주 사용하는 클래스로 웹 어플리케이션의 컨트롤러가 클라이언트의 요청을 처리한 후 반환하는 결과를 객체에 담는 클래스이다.
ModelAndView 클래스는 모델 데이터와 뷰 이름을 함께 관리해 컨트롤러가 처리한 데이터를 뷰에 전달하고 어떤 뷰를 렌더링할지 결정하는 역할을 한다.
이때 Model이 데이터를 의미한다. Model은 컨트롤러가 뷰에 전달할 데이터를 담고 있다. 주로 Map 형태로 데이터를 저장하여, 키-값 쌍으로 데이터를 관리한다. 이 코드에서 Map 형태를 사용한 부분은 없지만
또한 ModelAndView는 렌더링할 뷰의 이름을 포함한다. 이 이름은 ViewResolver에 의해 실제 뷰 객체로 해석된다.
즉, 요약하자면 ModelAndView는 데이터를 뷰에 전달하고 뷰를 선택하는 과정을 담은 클래스라고 할 수 있다.
ModelAndView는 많은 형태의 생성자를 가지고 있으며 

```java

public ModelAndView() {
	}

	/**
	 * Convenient constructor when there is no model data to expose.
	 * Can also be used in conjunction with {@code addObject}.
	 * @param viewName name of the View to render, to be resolved
	 * by the DispatcherServlet's ViewResolver
	 * @see #addObject
	 */
	public ModelAndView(String viewName) {
		this.view = viewName;
	}

	/**
	 * Convenient constructor when there is no model data to expose.
	 * Can also be used in conjunction with {@code addObject}.
	 * @param view the View object to render
	 * @see #addObject
	 */
	public ModelAndView(View view) {
		this.view = view;
	}

	/**
	 * Create a new ModelAndView given a view name and a model.
	 * @param viewName name of the View to render, to be resolved
	 * by the DispatcherServlet's ViewResolver
	 * @param model a Map of model names (Strings) to model objects
	 * (Objects). Model entries may not be {@code null}, but the
	 * model Map may be {@code null} if there is no model data.
	 */
	public ModelAndView(String viewName, @Nullable Map<String, ?> model) {
		this.view = viewName;
		if (model != null) {
			getModelMap().addAllAttributes(model);
		}
	}

	/**
	 * Create a new ModelAndView given a View object and a model.
	 * <em>Note: the supplied model data is copied into the internal
	 * storage of this class. You should not consider to modify the supplied
	 * Map after supplying it to this class</em>
	 * @param view the View object to render
	 * @param model a Map of model names (Strings) to model objects
	 * (Objects). Model entries may not be {@code null}, but the
	 * model Map may be {@code null} if there is no model data.
	 */
	public ModelAndView(View view, @Nullable Map<String, ?> model) {
		this.view = view;
		if (model != null) {
			getModelMap().addAllAttributes(model);
		}
	}

	/**
	 * Create a new ModelAndView given a view name and HTTP status.
	 * @param viewName name of the View to render, to be resolved
	 * by the DispatcherServlet's ViewResolver
	 * @param status an HTTP status code to use for the response
	 * (to be set just prior to View rendering)
	 * @since 4.3.8
	 */
	public ModelAndView(String viewName, HttpStatusCode status) {
		this.view = viewName;
		this.status = status;
	}

	/**
	 * Create a new ModelAndView given a view name, model, and HTTP status.
	 * @param viewName name of the View to render, to be resolved
	 * by the DispatcherServlet's ViewResolver
	 * @param model a Map of model names (Strings) to model objects
	 * (Objects). Model entries may not be {@code null}, but the
	 * model Map may be {@code null} if there is no model data.
	 * @param status an HTTP status code to use for the response
	 * (to be set just prior to View rendering)
	 * @since 4.3
	 */
	public ModelAndView(@Nullable String viewName, @Nullable Map<String, ?> model, @Nullable HttpStatusCode status) {
		this.view = viewName;
		if (model != null) {
			getModelMap().addAllAttributes(model);
		}
		this.status = status;
	}

	/**
	 * Convenient constructor to take a single model object.
	 * @param viewName name of the View to render, to be resolved
	 * by the DispatcherServlet's ViewResolver
	 * @param modelName name of the single entry in the model
	 * @param modelObject the single model object
	 */
	public ModelAndView(String viewName, String modelName, Object modelObject) {
		this.view = viewName;
		addObject(modelName, modelObject);
	}

	/**
	 * Convenient constructor to take a single model object.
	 * @param view the View object to render
	 * @param modelName name of the single entry in the model
	 * @param modelObject the single model object
	 */
	public ModelAndView(View view, String modelName, Object modelObject) {
		this.view = view;
		addObject(modelName, modelObject);
	}

```

실제 ModelAndView 클래스 구현 코드이다.

아무튼 이 중에서도 View 타입의 객체를 매개변수로 담는

public ModelAndView(View view) {
		this.view = view;
	}
 
 생성자를 사용했다.

 사실 about.html 파일은 src/main/resources/templates/first 아래에 있다.
 그런데 앞 경로를 생략하고 /first/about 라고만 지정해 사용할 수 있는 이유는 위에서 잠깐 언급한 ViewResolver의 역할 덕분이다. 
 SpringBoot는 기본적으로 Thymeleaf 템플릿을 사용하도록 설정되어 있고 기본 설정에서 템플릿 파일은 src/main/resources/templates 디렉터리 안에 있어야 한다. 
 물론 뷰 파일의 확장자는 html로 설정.
 아무튼 SpringBoot는 자동으로 ThymelafViewResolver를 설정하고 이 뷰 리졸버는 설정된 경로와 확장자를 기반으로 뷰를 해석하고 탐색한다.

 아무튼 본론으로 돌아오자면 위 코드는 설정한 경로의 뷰 파일을 View에 담고 그 View를 반환하는 코드라고 할 수 있다. 

 about.html 코드는 단순 html 구성의 파일이라 코드 리뷰는 생략한다.

  

공지사항과 Q&A 게시판 구현(프론트엔드/백엔드)
- thymeleaf를 이용해 데이터를 동적으로 렌더링하여 html 페이지 구현
- 게시글 작성, 등록, 조회, 삭제, 수정 기능 구현



