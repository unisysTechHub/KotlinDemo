
sealed class Expr
{
    class Const(val value : Double) : Expr()
    class Sum(val e1 : Expr, val e2 : Expr) : Expr()
    object NotNumber : Expr()
    fun eval() = when(this)
    {
        is Const -> this.value
        is Sum ->  if (e1 is Const && e2 is Const)
                         e1.value + e2.value
                   else
                         Double.NaN
        is NotNumber -> Double.NaN
    }

}

fun mainSealed()
{
    val sum = Expr.Sum(e1 = Expr.Const(10.0), e2 = Expr.Const(11.0))
    println(sum.eval())

}
