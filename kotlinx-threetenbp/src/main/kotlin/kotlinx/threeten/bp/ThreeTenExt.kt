/*
* Copyright 2017 Andrew Chen
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

@file:Suppress("NOTHING_TO_INLINE")

package kotlinx.threeten.bp

import org.threeten.bp.DateTimeUtils
import org.threeten.bp.ZoneId
import org.threeten.bp.LocalDateTime
import java.util.Date

inline fun Date.toLocalDateTime() =
        DateTimeUtils.toInstant(this).atZone(ZoneId.systemDefault()).toLocalDateTime()

inline fun LocalDateTime.toDate() =
        DateTimeUtils.toDate(this.atZone(ZoneId.systemDefault()).toInstant())

//val LocalDateTime.epochSecond: Long
inline fun LocalDateTime.toEpochSecond() = this.atZone(ZoneId.systemDefault()).toInstant().epochSecond
