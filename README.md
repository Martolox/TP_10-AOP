# TP 10 - Aspect Oriented Programming

Es un paradigma para el cual se pueden encapsular los diferentes conceptos que componen una aplicación en entidades bien definidas, eliminando las dependencias entre cada uno de los módulos. De esta forma se consigue razonar mejor sobre los conceptos, se elimina la dispersión del código y las implementaciones resultan más comprensibles, adaptables y reusables.
- Code Scattering: El código correspondiente a una incumbencia, la registración en el ejemplo, no es encapsulado en un único módulo/clase, sino que aparece disperso por el programa (en Tecnico, Jugador, Dirigente, etc). Duplicando estas invocaciones a la registración hace que donde deba agregar un parámetro requiera de múltiples cambios.
- Code Tangling: Dentro de un mismo módulo/clase encontramos código correspondiente a distintos concerns. En el ejemplo encontramos código que atañe al comportamiento funcional y código que corresponde a la registración del insulto. Una clase se ve impactada por razones diferentes, lo que hace más compleja el manteniemiento.
-Dependencias:
	-AspectJ

### Radio Competition (TP 4 - Layers)
Se pide reimplementar el inciso de TP competencia radial con una anotación @Log que permita marcar los métodos para registrar al usuario.