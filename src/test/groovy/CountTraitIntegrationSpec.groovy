import spock.lang.Specification

class CountTraitIntegrationSpec extends Specification {

	def 'CountTrait functions when implemented'() {
		given:
		CounterA counterA = new CounterA()

		when:
		counterA.countUp()

		then:
		counterA.count == 1
	}

	def 'CountTrait functions multiple times'() {
		given:
		CounterA counterA = new CounterA()

		when:
		counterA.countUp()
		counterA.countUp()

		then:
		counterA.count == 2
	}

	def 'CountTrait maintains separate state among multiple instances'() {
		given:
		CounterA counterA1 = new CounterA()
		CounterA counterA2 = new CounterA()

		when:
		counterA1.countUp()
		counterA2.countUp()
		counterA2.countUp()

		then:
		counterA1.count == 1
		counterA2.count == 2
	}

	def 'CountTrait maintains separate state among multiple classes'() {
		given:
		CounterA counterA = new CounterA()
		CounterB counterB = new CounterB()

		when:
		counterA.countUp()
		counterB.countUp()
		counterB.countUp()

		then:
		counterA.count == 1
		counterB.count == 2
	}

}
