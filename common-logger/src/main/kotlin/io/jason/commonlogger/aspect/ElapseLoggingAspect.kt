package io.jason.commonlogger.aspect

import io.jason.commonlogger.util.LoggerUtil
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component
import org.springframework.util.StopWatch


@Component
@Aspect
class ElapseLoggingAspect {
    private val logger = LoggerUtil()

    @Around("@annotation(io.jason.commonlogger.annotation.ElapseLoggable)")
    fun printElapseTime(joinPoint: ProceedingJoinPoint): Any {
        val stopWatch = StopWatch()
        stopWatch.start()

        val result: Any;
        try {
            result = joinPoint.proceed() as Object
        } finally {
            stopWatch.stop()

            val methodName = joinPoint.signature.name
            val elapsedTime = stopWatch.lastTaskInfo().timeMillis
            if(elapsedTime > 1000)
                logger.warn("[Method - E] : ${methodName} - $elapsedTime ms")
            else
                logger.info("[Method - E] : ${methodName} - $elapsedTime ms")

        }

        return result


    }
}