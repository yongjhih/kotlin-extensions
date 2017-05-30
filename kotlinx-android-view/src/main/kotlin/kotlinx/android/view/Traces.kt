/*
 * Copyright (C) 2017 Andrew Chen
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package kotlinx.android.trace

import android.os.Trace

inline fun <T> trace(sectionName: String, body: () -> T): T {
  Trace.beginSection(sectionName)
  try {
    return body()
  } finally {
    Trace.endSection()
  }
}
