package org.vendorunlockingpatterns.apigatewayfederator.utils;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.Supplier;

import org.slf4j.Logger;
import org.slf4j.Marker;

public class AgfLogger implements Logger {

	private final Logger delegate;

	@SafeVarargs
	private static final Object[] toObjectArray(Supplier<Object>... suppliers) {
		return Arrays.stream(suppliers).map(Supplier::get).toArray();
	}

	public AgfLogger(Logger logger) {
		Objects.requireNonNull(logger);
		this.delegate = logger;
	}

	private static void log(Supplier<String> msgSupplier, BooleanSupplier logLevelEnabledChecker,
			Consumer<String> logMethod) {
		if (logLevelEnabledChecker.getAsBoolean()) {
			logMethod.accept(msgSupplier.get());
		}
	}

	private static void log(Supplier<String> msgSupplier, Throwable t, BooleanSupplier logLevelEnabledChecker,
			BiConsumer<String, Throwable> logMethod) {
		if (logLevelEnabledChecker.getAsBoolean()) {
			logMethod.accept(msgSupplier.get(), t);
		}
	}

	@Override
	public String getName() {
		return delegate.getName();
	}

	@Override
	public boolean isTraceEnabled() {
		return delegate.isTraceEnabled();
	}

	@Override
	public void trace(String msg) {
		delegate.trace(msg);
	}

	public void trace(Supplier<String> msgSupplier) {
		log(msgSupplier, delegate::isTraceEnabled, delegate::trace);
	}

	@Override
	public void trace(String format, Object arg) {
		delegate.trace(format, arg);
	}

	@Override
	public void trace(String format, Object arg1, Object arg2) {
		delegate.trace(format, arg1, arg2);
	}

	@Override
	public void trace(String format, Object... arguments) {
		delegate.trace(format, arguments);
	}

	@Override
	public void trace(String msg, Throwable t) {
		trace(() -> msg, t);
	}

	public void trace(Supplier<String> msgSupplier, Throwable t) {
		log(msgSupplier, t, delegate::isTraceEnabled, delegate::trace);
	}

	@Override
	public boolean isTraceEnabled(Marker marker) {
		return delegate.isTraceEnabled(marker);
	}

	@Override
	public void trace(Marker marker, String msg) {
		delegate.trace(marker, msg);
	}

	@Override
	public void trace(Marker marker, String format, Object arg) {
		delegate.trace(marker, format, arg);
	}

	@Override
	public void trace(Marker marker, String format, Object arg1, Object arg2) {
		delegate.trace(marker, format, arg1, arg2);
	}

	@Override
	public void trace(Marker marker, String format, Object... argArray) {
		delegate.trace(marker, format, argArray);
	}

	@Override
	public void trace(Marker marker, String msg, Throwable t) {
		delegate.trace(marker, msg, t);
	}

	@Override
	public boolean isDebugEnabled() {
		return delegate.isDebugEnabled();
	}

	@Override
	public void debug(String msg) {
		delegate.debug(msg);
	}

	public void debug(Supplier<String> msgSupplier) {
		log(msgSupplier, delegate::isDebugEnabled, delegate::debug);
	}

	@Override
	public void debug(String format, Object arg) {
		delegate.debug(format, arg);
	}

	public void debug(String format, Supplier<Object> argSupplier) {
		if (delegate.isDebugEnabled()) {
			delegate.debug(format, argSupplier.get());
		}
	}

	@SafeVarargs
	public final void debug(String format, Supplier<Object>... argSuppliers) {
		if (delegate.isDebugEnabled()) {
			delegate.debug(format, toObjectArray(argSuppliers));
		}
	}

	@Override
	public void debug(String format, Object arg1, Object arg2) {
		delegate.debug(format, arg1, arg2);
	}

	@Override
	public void debug(String format, Object... arguments) {
		delegate.debug(format, arguments);
	}

	@Override
	public void debug(String msg, Throwable t) {
		debug(() -> msg, t);
	}

	public void debug(Supplier<String> msgSupplier, Throwable t) {
		log(msgSupplier, t, delegate::isDebugEnabled, delegate::debug);
	}

	@Override
	public boolean isDebugEnabled(Marker marker) {
		return delegate.isDebugEnabled(marker);
	}

	@Override
	public void debug(Marker marker, String msg) {
		delegate.debug(marker, msg);
	}

	@Override
	public void debug(Marker marker, String format, Object arg) {
		delegate.debug(marker, format, arg);
	}

	@Override
	public void debug(Marker marker, String format, Object arg1, Object arg2) {
		delegate.debug(marker, format, arg1, arg2);
	}

	@Override
	public void debug(Marker marker, String format, Object... arguments) {
		delegate.debug(marker, format, arguments);
	}

	@Override
	public void debug(Marker marker, String msg, Throwable t) {
		delegate.debug(marker, msg, t);
	}

	@Override
	public boolean isInfoEnabled() {
		return delegate.isInfoEnabled();
	}

	@Override
	public void info(String msg) {
		delegate.info(msg);
	}

	public void info(Supplier<String> msgSupplier) {
		log(msgSupplier, delegate::isInfoEnabled, delegate::info);
	}

	@Override
	public void info(String format, Object arg) {
		delegate.info(format, arg);
	}

	public void info(String format, Supplier<Object> argSupplier) {
		if (delegate.isInfoEnabled()) {
			delegate.info(format, argSupplier.get());
		}
	}

	@SafeVarargs
	public final void info(String format, Supplier<Object>... argSuppliers) {
		if (delegate.isInfoEnabled()) {
			delegate.info(format, toObjectArray(argSuppliers));
		}
	}

	@Override
	public void info(String format, Object arg1, Object arg2) {
		delegate.info(format, arg1, arg2);
	}

	@Override
	public void info(String format, Object... arguments) {
		delegate.info(format, arguments);
	}

	@Override
	public void info(String msg, Throwable t) {
		info(() -> msg, t);
	}

	public void info(Supplier<String> msgSupplier, Throwable t) {
		log(msgSupplier, t, delegate::isInfoEnabled, delegate::info);
	}

	@Override
	public boolean isInfoEnabled(Marker marker) {
		return delegate.isInfoEnabled(marker);
	}

	@Override
	public void info(Marker marker, String msg) {
		delegate.info(marker, msg);
	}

	@Override
	public void info(Marker marker, String format, Object arg) {
		delegate.info(marker, format, arg);
	}

	@Override
	public void info(Marker marker, String format, Object arg1, Object arg2) {
		delegate.info(marker, format, arg1, arg2);
	}

	@Override
	public void info(Marker marker, String format, Object... arguments) {
		delegate.info(marker, format, arguments);
	}

	@Override
	public void info(Marker marker, String msg, Throwable t) {
		delegate.info(marker, msg, t);
	}

	@Override
	public boolean isWarnEnabled() {
		return delegate.isWarnEnabled();
	}

	@Override
	public void warn(String msg) {
		delegate.warn(msg);
	}

	public void warn(Supplier<String> msgSupplier) {
		log(msgSupplier, delegate::isWarnEnabled, delegate::warn);
	}

	@Override
	public void warn(String format, Object arg) {
		delegate.warn(format, arg);
	}

	public void warn(String format, Supplier<Object> argSupplier) {
		if (delegate.isWarnEnabled()) {
			delegate.warn(format, argSupplier.get());
		}
	}

	@Override
	public void warn(String format, Object... arguments) {
		delegate.warn(format, arguments);
	}

	@SafeVarargs
	public final void warn(String format, Supplier<Object>... argSuppliers) {
		if (delegate.isWarnEnabled()) {
			delegate.warn(format, toObjectArray(argSuppliers));
		}
	}

	@Override
	public void warn(String format, Object arg1, Object arg2) {
		delegate.warn(format, arg1, arg2);
	}

	@Override
	public void warn(String msg, Throwable t) {
		warn(() -> msg, t);
	}

	public void warn(Supplier<String> msgSupplier, Throwable t) {
		log(msgSupplier, t, delegate::isWarnEnabled, delegate::warn);
	}

	@Override
	public boolean isWarnEnabled(Marker marker) {
		return delegate.isWarnEnabled(marker);
	}

	@Override
	public void warn(Marker marker, String msg) {
		delegate.warn(marker, msg);
	}

	@Override
	public void warn(Marker marker, String format, Object arg) {
		delegate.warn(marker, format, arg);
	}

	@Override
	public void warn(Marker marker, String format, Object arg1, Object arg2) {
		delegate.warn(marker, format, arg1, arg2);
	}

	@Override
	public void warn(Marker marker, String format, Object... arguments) {
		delegate.warn(marker, format, arguments);
	}

	@Override
	public void warn(Marker marker, String msg, Throwable t) {
		delegate.warn(marker, msg, t);
	}

	@Override
	public boolean isErrorEnabled() {
		return delegate.isErrorEnabled();
	}

	@Override
	public void error(String msg) {
		delegate.error(msg);
	}

	public void error(Supplier<String> msgSupplier) {
		log(msgSupplier, delegate::isErrorEnabled, delegate::error);
	}

	@Override
	public void error(String format, Object arg) {
		delegate.error(format, arg);
	}

	@Override
	public void error(String format, Object arg1, Object arg2) {
		delegate.error(format, arg1, arg2);
	}

	@Override
	public void error(String format, Object... arguments) {
		delegate.error(format, arguments);
	}

	@Override
	public void error(String msg, Throwable t) {
		error(() -> msg, t);
	}

	public void error(Supplier<String> msgSupplier, Throwable t) {
		log(msgSupplier, t, delegate::isErrorEnabled, delegate::error);
	}

	@Override
	public boolean isErrorEnabled(Marker marker) {
		return delegate.isErrorEnabled(marker);
	}

	@Override
	public void error(Marker marker, String msg) {
		delegate.error(marker, msg);
	}

	@Override
	public void error(Marker marker, String format, Object arg) {
		delegate.error(marker, format, arg);
	}

	@Override
	public void error(Marker marker, String format, Object arg1, Object arg2) {
		delegate.error(marker, format, arg1, arg2);
	}

	@Override
	public void error(Marker marker, String format, Object... arguments) {
		delegate.error(marker, format, arguments);
	}

	@Override
	public void error(Marker marker, String msg, Throwable t) {
		delegate.error(marker, msg, t);
	}

}
